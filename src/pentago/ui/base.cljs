(ns pentago.ui.base)

(defn square [color]
  [:div.square {:data-color (name color)}
   [:a {:href "#"}]])
