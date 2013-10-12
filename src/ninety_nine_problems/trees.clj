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

; Return to problem 55

(defn same-tree?
    [tree1 tree2]
    (if (and (nil? tree1) (nil? tree2))
        true
    (if (or (nil? tree1) (nil? tree2))
        false
        (let
            [[_ left1 right1] tree1
            [_ left2 right2] tree2]
            (and
                (same-tree? left1 left2)
                (same-tree? right1 right2))))))

(defn symmetric?
    [tree]
    (or
        (nil? tree)
        (let [[_ left right] tree]
            (same-tree? left right))))
