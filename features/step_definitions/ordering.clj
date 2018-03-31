(require '[clojure.test :refer [is]])
(require '[features.support.param :as param])
(require '[features.support.world :as world])
(require '[order.core :as order])

(Given #"^the base price for a pizza is (\d+) €$" [price]
  (let [price (param/number price)]
    (swap! world/menu assoc :pizza price)))

(Given #"^the following toppings are available for ordering:$" [toppings]
  (let [toppings (param/map-of-keywords-to-numbers toppings)]
    (swap! world/menu merge toppings)))

(When #"^I order a pizza with:$" [toppings]
  (let [toppings (param/list-of-keywords toppings)]
    (reset! world/current-order (conj toppings :pizza))))

(Then #"^the total price should be (\d+) €$" [total]
  (let [total (param/number total)]
    (is (= total (order/total @world/menu @world/current-order)))))
