(ns features.support.param
  (:require [clojure.string :as string]))

(def lower-case-keyword (comp keyword string/lower-case))

(def number (comp read-string (partial re-find #"\d+")))

(defn map-of-keywords-to-numbers [data-table]
  (into {}
        (map (fn [[k v]]
               {(lower-case-keyword k) (number v)}))
        (.raw data-table)))

(defn list-of-keywords [data-table]
  (into []
        (map (comp lower-case-keyword first))
        (.raw data-table)))
