(ns pentago.styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [rule]]
            [garden.selectors :as sel]
            [garden.units :as u]))

(defstyles screen
  [:* {:box-sizing "border-box"}]

  [:.square
   ["&[data-color='black']"
    {:background-color "black"}]

   ["&[data-color='white']"
    {:background-color "white"}]

   {:background-color "grey"
    :border "black 2px solid"
    :height "40px"
    :width "40px"
    :margin "5px"}]

  [:.row {:display "flex"
          :flex-direction "row"}]

  [:.quadrant
   {:display "flex"
    :flex-direction "column"}]

  [:.board
   ["> .row:first-child"
    {:border-bottom "black 10px solid"}]

   ["> .row > .quadrant:first-child"
    {:border-right "black 10px solid"}]

   {:display "flex"
    :width "auto"
    :flex-direction "column"}])
