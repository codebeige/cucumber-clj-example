(ns order.core)

(defn total [menu order]
  (reduce (fn [total item] (+ total (item menu))) 0 order))
