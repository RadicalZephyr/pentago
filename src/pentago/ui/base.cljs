(ns pentago.ui.base)

(defn square [color]
  [:div.square {:data-color (name color)}
   [:a {:href "#"}]])

(defn quadrant []
  [:div.quadrant
   [:div.row (repeat 3 [:div.square])]
   [:div.row (repeat 3 [:div.square])]
   [:div.row (repeat 3 [:div.square])]])

(defn board []
  [:div.board
   [:div.row (repeat 2 [quadrant])]
   [:div.row (repeat 2 [quadrant])]])
