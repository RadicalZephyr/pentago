(ns pentago.ui.base)

(defn square [color]
  [:div.square (if color {:data-color (name color)} {})])

(defn quadrant []
  [:div.quadrant
   [:div.row (repeat 3 [square nil])]
   [:div.row (repeat 3 [square nil])]
   [:div.row (repeat 3 [square nil])]])

(defn board []
  [:div.board
   [:div.row (repeat 2 [quadrant])]
   [:div.row (repeat 2 [quadrant])]])
