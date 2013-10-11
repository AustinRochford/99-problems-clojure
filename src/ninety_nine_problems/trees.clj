(ns ninety-nine-problems.trees
    (:require
        [clojure.contrib.core :refer :all])
    (:gen-class))

(defn tree?
    [tree]
    (or
        (nil? tree)
        (if (= 3 (count tree))
            (let [[_ left right] tree]
                (and (tree? left) (tree? right))))))
