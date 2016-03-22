(ns pentago.ui.base-test
  (:require [cljs.test :refer-macros [is testing]]
            [devcards.core :refer-macros [deftest defcard-rg]]
            [pentago.ui.base :as sut]
            [reagent.core]))

(defcard-rg square
  [:div
   [sut/square :none]
   [sut/square :black]
   [sut/square :white]])

(defcard-rg quadrant
  [sut/quadrant])

(defcard-rg board
  [sut/board])
