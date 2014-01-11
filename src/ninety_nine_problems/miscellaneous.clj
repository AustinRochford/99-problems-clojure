(ns ninety-nine-problems.miscellaneous
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.contrib.math :refer [abs]]
        [clojure.math.combinatorics :refer :all]
        [ninety-nine-problems.core :refer :all])
    (:gen-class))

; Helpers for Problem 90
(defn diagonal-threat
    "Determine if the two positions threaten each other diagonally"
    [[row1 col1] [row2 col2]]
    (=
        (abs (- row1 row2))
        (abs (- col1 col2))))

(defn no-diagonal-threats
    "Determine if no two positions in board threaten each other diagonally"
    [board]
    (let
        [coords (map vector board (range 1 (inc (count board))))]
        (->>
            (cartesian-product coords coords)
            (filter #(not (= (first %) (second %))))
            (every? (partial apply (complement diagonal-threat))))))

; Problem 90
(defn queens
    "Solve the queens problem on an n x n chessboard"
    [n]
    (->>
        (inc n)
        (range 1)
        (permutations)
        (filter no-diagonal-threats)))
