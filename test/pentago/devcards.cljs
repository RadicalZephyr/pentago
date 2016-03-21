(ns pentago.devcards
  (:require [devcards.core :as dc :include-macros true]))

(defn run-devcards! []
  (dc/start-devcard-ui!))
