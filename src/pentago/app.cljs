(ns pentago.app
  (:require [reagent.core :as reagent]
            [reagent.ratom :as ratom]
            [re-frame.core :as re-frame]))

(defn setup-re-frame! []
  (re-frame/register-handler
   :initialise-db
   (fn
     [_ _]
     {})))

(defn main-panel []
  [:div [:h1 "Hello World"]])

(defn init-render! []
  (re-frame/dispatch [:initialise-db])
  (reagent/render [main-panel]
                  (.getElementById js/document "app")))

(defn ^:export setup! []
  (setup-re-frame!)
  (init-render!))
