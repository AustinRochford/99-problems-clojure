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

(defn but-last
    [coll]
    (let
        [[head snd & tail] coll]
        (if (nil? snd)
            nil
        (if (empty? tail)
            head
            (recur (conj tail snd))))))

(defn element-at
    [coll k]
    (if (empty? coll)
        nil
    (if (= k 1)
        (first coll)
        (recur (rest coll) (dec k)))))

(def length
    (comp
        (partial reduce +)
        (partial map (constantly 1))))

(defn reverse'
    [coll]
    (if (empty? coll)
        '()
        (reduce conj '() coll)))

(defn palindrome?
    [coll]
    (= coll (reverse' coll)))

(defn flatten'
    [coll]
    (if (empty? coll)
        '()
        (let [[head & tail] coll]
            (if (seq? head)
                (concat (flatten' head) (flatten' tail))
                (conj (flatten' tail) head)))))

(def compress
    (comp
        (partial map first)
        (partial partition-by identity)))

(def pack (partial partition-by identity))

(def encode 
    (comp
        (partial map #(vector (count %) (first %)))
        pack))

(def encode'
    (comp
        (partial map
            (fn [coll]
                (let [[head & tail] coll]
                    (if (empty? tail)
                        head
                        [(count coll) head]))))
        pack))

(def decode
    (partial mapcat
        (fn [encoded]
            (if (vector? encoded)
                (apply replicate encoded)
                (replicate 1 encoded)))))

(def duplicate
    (partial mapcat (partial replicate 2)))

(defn replicate'
    [coll n]
    (mapcat (partial replicate n) coll))

(defn drop-every
    [coll n]
    (mapcat 
        (fn [part]
            (if (= (count part) n)
                (butlast part)
                part))
        (partition-all n coll)))

(defn split
    [coll n]
    (if (empty? coll)
        ['() '()]
    (if (zero? n)
        ['() coll]
        (let 
            [[head & tail]  coll
            [before after]  (split tail (dec n))]
            [(conj before head) after]))))

(defn slice
    [coll m n]
    (->> coll
        (drop (dec m))
        (take (inc (- n m)))))
