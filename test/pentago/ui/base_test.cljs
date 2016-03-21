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

(defcard-rg grid
  [:div {:style {:border "3px cornflowerblue solid"}}
   [:div
    [:div.test.column.half [:p " "]]
    [:div.test.column.half [:p " "]]
    [:br]]

   [:div
    [:div.test.column.third [:p " "]]
    [:div.test.column.third [:p " "]]
    [:div.test.column.third [:p " "]]
    [:br]]

   [:div
    [:div.test.column.third [:p " "]]
    [:div.test.column.two-thirds [:p " "]]
    [:br]]

   [:div
    [:div.test.column.fourth [:p " "]]
    [:div.test.column.fourth [:p " "]]
    [:div.test.column.fourth [:p " "]]
    [:div.test.column.fourth [:p " "]]
    [:br]]

   [:div
    [:div.test.column.three-fourths [:p " "]]
    [:div.test.column.fourth [:p " "]]
    [:br]]

   [:div
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:br]]

   [:div
    [:div.test.column.three-fifths [:p " "]]
    [:div.test.column.two-fifths [:p " "]]
    [:br]]
   [:div
    [:div.test.column.two-fifths [:p " "]]
    [:div.test.column.three-fifths [:p " "]]
    [:br]]

   [:div
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:br]]

   [:div
    [:div.test.column.four-fifths [:p " "]]
    [:div.test.column.fifth [:p " "]]
    [:br]]])
