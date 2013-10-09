(ns ninety-nine-problems.lists
    (:require
        [clojure.contrib.core :refer :all])
    (:gen-class))

(defn last'
    [coll]
    (let
        [[head & tail] coll]
        (if (empty? tail)
            head
            (recur tail))))
