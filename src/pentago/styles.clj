(ns pentago.styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [rule]]
            [garden.units :as u]))

(defn- fudge-factor [gutter-width x n]
  (if (= x 1)
    0
    (* gutter-width
       ;; The 3 is a "fudge factor" to make sure it's a bit smaller than
       ;; precisely 100%
       (/ x (+ 3 n)))))

(defn- percent-for-x-nths [gutter-width x n]
  (u/percent
   (+
    (* (- 100
          (* gutter-width
             (- n x)))
       (/ x n))
    (fudge-factor gutter-width x n))))

(defstyles screen
  [:* {:box-sizing "border-box"}]

  [:.square
   [:&.black {:background-color "black"}]
   [:&.white {:background-color "white"}]

   {:background-color "grey"
    :border "black 2px solid"
    :height "40px"
    :width "40px"
    :margin "5px"}]

  (let [margin-width 3/4
        percent-for (partial percent-for-x-nths margin-width)]

    [:.column
     {:float "left"
      :margin [[0 0 0 (u/percent margin-width)]]
      :width "100%"}

     [:&:first-of-type {:margin-left 0}]

     [:&.half          {:width (percent-for 1 2)}]
     [:&.third         {:width (percent-for 1 3)}]
     [:&.two-thirds    {:width (percent-for 2 3)}]
     [:&.fourth        {:width (percent-for 1 4)}]
     [:&.three-fourths {:width (percent-for 3 4)}]
     [:&.fifth         {:width (percent-for 1 5)}]
     [:&.two-fifths    {:width (percent-for 2 5)}]
     [:&.three-fifths  {:width (percent-for 3 5)}]
     [:&.four-fifths   {:width (percent-for 4 5)}]])

  [:.test {:background-color "tomato"}])
