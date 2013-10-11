(ns ninety-nine-problems.logic-codes
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.data.priority-map :refer :all])
    (:gen-class))

(defn gray-code
    [n]
    (if (= n 1)
        '((0) (1))
        (let [code (gray-code (dec n))]
            (concat
                (map #(conj % 0) code)
                (map #(conj % 1) (reverse code))))))

(defn huffman-step
    [[fst p1] [snd p2]]
    [`(nil ~fst ~snd) (+ p1 p2)])

(defn pop'
    [n queue]
    [(take n queue) (nth (iterate pop queue) n)])

(defn huffman-tree
    [queue]
    (if (= 1 (count queue))
        (peek queue)
        (let [[[fst snd] queue'] (pop' 2 queue)]
            (->>
                (huffman-step fst snd)
                (conj queue')
                (recur)))))

(defn huffman-code-from-tree
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

(defn huffman-code
    [freqs]
    (let [[tree _] (huffman-tree freqs)]
        (huffman-code-from-tree tree)))
