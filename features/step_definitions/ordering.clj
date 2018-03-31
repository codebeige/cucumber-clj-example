(require '[clojure.test :refer [is]])
(require '[clojure.string :as string])
(require '[order.core :as order])

(def menu (atom {}))
(def current-order (atom nil))

(def lower-case-keyword (comp keyword string/lower-case))
(def digits->number (comp read-string (partial re-find #"\d+")))

(Given #"^the base price for a pizza is (\d+) €$" [price]
  (let [price (digits->number price)]
    (swap! menu assoc :pizza price)))

(Given #"^the following toppings are available for ordering:$" [toppings]
  (let [toppings (into {}
                       (map (fn [[k v]]
                              {(lower-case-keyword k) (digits->number v)}))
                       (.raw toppings))]
    (swap! menu merge toppings)))

(When #"^I order a pizza with:$" [toppings]
  (let [toppings (into []
                       (map (comp lower-case-keyword first))
                       (.raw toppings))]
    (reset! current-order (conj toppings :pizza))))

(Then #"^the total price should be (\d+) €$" [total]
  (let [total (digits->number total)]
    (is (= total (order/total @menu @current-order)))))
