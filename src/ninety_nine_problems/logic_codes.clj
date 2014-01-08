(ns ninety-nine-problems.logic-codes
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.data.priority-map :refer :all])
    (:gen-class))

; Problem 49
(defn gray-code
    "Generate the n-bit Gray code"
    [n]
    (if (= n 1)
        '((0) (1))
        (let [code (gray-code (dec n))]
            (concat
                (map #(conj % 0) code)
                (map #(conj % 1) (reverse code))))))

; Helpers for problem 50
(defn merge-trees
    "Merge two trees and add their weights"
    [[fst p1] [snd p2]]
    [(list nil fst snd) (+ p1 p2)])

(defn pop'
    "Pop n elements from a queue"
    [n queue]
    [(take n queue) (nth (iterate pop queue) n)])

(defn huffman-tree
    "Recursively build the Huffman tree from a proprity queue"
    [queue]
    (if (= 1 (count queue))
        (peek queue)
        (let [[[fst snd] queue'] (pop' 2 queue)]
            (->>
                (merge-trees fst snd)
                (conj queue')
                (recur)))))

(defn huffman-code-from-tree
    "Given a Huffman tree, generate the corresponding code"
    [tree]
    (if (not (seq? tree))
        (hash-map tree '())
        (let
            [[_ left right] tree
            lefts           (huffman-code-from-tree left)
            rights          (huffman-code-from-tree right)]
            (merge
                (->>
                    (map #(vector (first %) (conj (second %) 0)) lefts)
                    (into {}))
                (->>
                    (map #(vector (first %) (conj (second %) 1)) rights)
                    (into {}))))))

; Problem 50
(defn huffman-code
    "Generate a Huffman code from a priority queue"
    [freqs]
    (let [[tree _] (huffman-tree freqs)]
        (huffman-code-from-tree tree)))
