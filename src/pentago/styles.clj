(ns pentago.styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [rule]]
            [garden.selectors :as sel]
            [garden.units :as u]))

(defn- calculate-quadrant-size [square-size square-margin]
  (u/px* 3
         (u/px+ square-size
                (u/px* 2 square-margin))))

(defn- calculate-board-size [quadrant-size border-width]
  (u/px+ border-width (u/px* 2 quadrant-size)))


(let [square-size (u/px 40)
      square-margin (u/px 5)
      border-width (u/px 10)
      quadrant-size (calculate-quadrant-size square-size
                                             square-margin)
      board-size (calculate-board-size quadrant-size border-width)]

 (defstyles screen
   [:* {:box-sizing "border-box"}]

   [:.square
    [:&:hover {:cursor "pointer"}]

    ["&[data-color='black']"
     [:&:hover {:cursor "initial"}]
     {:background-color "black"}]

    ["&[data-color='white']"
     [:&:hover {:cursor "initial"}]
     {:background-color "white"}]

    {:background-color "grey"
     :border "black 2px solid"
     :border-radius "7px"
     :height square-size
     :width square-size
     :margin square-margin}]

   [:.row {:display "flex"
           :flex-direction "row"}]

   [:.quadrant
    {:display "flex"
     :height quadrant-size
     :width quadrant-size
     :flex-direction "column"}]

   [:.board
    ["> .row:first-child"
     {:border-bottom [["black" border-width "solid"]]
      :height (u/px+ quadrant-size border-width)}]

    ["> .row > .quadrant:first-child"
     {:border-right [["black" border-width "solid"]]
      :width (u/px+ quadrant-size border-width)}]

    {:display "flex"
     :width board-size
     :height board-size
     :flex-direction "column"}]))
