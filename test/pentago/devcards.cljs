(ns pentago.devcards
  (:require [devcards.core :as dc :include-macros true]
            [pentago.ui.base-test]))

(defn run-devcards! []
  (dc/start-devcard-ui!))
