(set-env!
 :source-paths    #{"src"}
 :resource-paths  #{"resources"}
 :dependencies    '[[org.clojure/clojurescript "1.7.228"]

                    [re-frame "0.7.0" :exclusions
                     [[org.clojure/clojurescript :extension "jar"]]]

                    ;; Dev/Release build code-gen
                    [hiccup "1.0.5"]
                    [garden "1.3.2"]

                    ;; Boot dev environment
                    [ring "1.4.0"]
                    [compojure "1.5.0"]
                    [devcards "0.2.1-6"]
                    [adzerk/boot-cljs              "1.7.228-1"]
                    [adzerk/boot-cljs-repl         "0.3.0"]
                    [adzerk/boot-reload            "0.4.5"]
                    [pandeiro/boot-http            "0.7.3"]
                    [org.martinklepsch/boot-garden "1.2.5-3"]

                    ;; cljs-repl
                    [com.cemerick/piggieback "0.2.1"]
                    [weasel                  "0.7.0"]
                    [org.clojure/tools.nrepl "0.2.12"]

                    ;; cljs tests
                    ;; Apparently 0.2.0-SNAPSHOT is the magic version
                    ;; where boot-cljs-test _actually works_...
                    [crisptrutski/boot-cljs-test "0.2.0-SNAPSHOT"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]]
 '[crisptrutski.boot-cljs-test :refer [test-cljs]]
 '[org.martinklepsch.boot-garden :refer [garden]])

(deftask build []
  (comp (speak)
        (cljs)
        (garden :styles-var 'pentago.styles/screen
                :output-to "public/css/app.css")
        (target)))

(deftask run []
  (comp (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production []
  (task-options! cljs {:ids #{"main"}
                       :optimizations :advanced})
  identity)

(deftask release
  "Simple task for creating a release build"
  []
  (comp (production)
        (build)))


(deftask development []
  (set-env! :source-paths #(conj % "dev-src"))
  (task-options! cljs {:optimizations :none
                       :source-map true
                       :compiler-options {:devcards true}}
                 reload {:asset-path "public"}
                 serve {:handler 'pentago.core/handler
                        :port 8080})
  identity)

(deftask testing []
  (set-env! :source-paths #(conj % "test"))
  identity)

(deftask dev
  "Simple task to run application in development mode"
  []
  (comp (development)
        (testing)
        (run)))

;;; This prevents a name collision WARNING between the test task and
;;; clojure.core/test, a function that nobody really uses or cares
;;; about.
(ns-unmap 'boot.user 'test)

(deftask test []
  (comp (testing)
        (test-cljs :js-env :phantom
                   :exit?  true)))

(deftask auto-test []
  (comp (testing)
        (watch)
        (test-cljs :js-env :phantom)))
