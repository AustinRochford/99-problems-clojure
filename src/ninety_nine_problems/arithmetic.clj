(ns ninety-nine-problems.arithmetic
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.contrib.math :refer [exact-integer-sqrt]])
    (:gen-class))

(defn sqrt
    [n]
    (nth (exact-integer-sqrt n) 0))

(defn divides?
    [k n]
    (zero? (mod n k)))

(defn prime?
    [n]
    (->>
        (sqrt n)
        (inc)
        (range 2)
        (filter #(divides? % n))
        (empty?)))

(defn gcd
    [m n]
    (if (< m n)
        (recur n m)
    (if (zero? n)
        m
        (recur n (mod m n)))))

(def coprime?
    (comp (partial = 1) gcd))

(defn totient
    [n]
    (->> n
        (range 1)
        (filter (partial coprime? n))
        (count)))

(defn prime-factors
    [n]
    (->> n
        (inc)
        (range 2)
        (filter #(and (divides? % n) (prime? %)))))
