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

(defn bst-add
    [tree x]
    (if (nil? tree)
        [x nil nil]
        (let [[y left right] tree]
            (if (< x y)
                [y (bst-add left x) right]
                [y left (bst-add right x)]))))

(def bst
    (partial reduce bst-add nil))

(defn leaf?
    [tree]
    (and
        (not (nil? tree))
        (let [[_ left right] tree]
            (and
                (nil? left)
                (nil? right)))))

(defn count-leaves
    [tree]
    (if (nil? tree)
        0
    (if (leaf? tree)
        1
        (let [[_ left right] tree]
            (+
                (count-leaves left)
                (count-leaves right))))))

(defn leaves
    [tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (if (leaf? tree)
                `(~x)
                (concat
                    (leaves left)
                    (leaves right))))))

(defn internals
    [tree]
    (if (or (nil? tree) (leaf? tree))
        '()
        (let [[x left right] tree]
            (conj
                (concat
                    (internals left)
                    (internals right))
                x))))

(defn at-level
    [n tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (if (= 1 n)
                `(~x)
                (concat
                    (at-level (dec n) left)
                    (at-level (dec n) right))))))
