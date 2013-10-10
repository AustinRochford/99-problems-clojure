(ns ninety-nine-problems.arithmetic
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.contrib.math :refer [exact-integer-sqrt floor]]
        [clojure.contrib.generic.math-functions :refer [pow]])
    (:gen-class))

(defn sqrt
    [n]
    (nth (exact-integer-sqrt n) 0))

(defn divides?
    [k n]
    (zero? (mod n k)))

(defn prime?
    [n]
    (if (= 1 n)
        false
        (->>
            (sqrt n)
            (inc)
            (range 2)
            (filter #(divides? % n))
            (empty?))))

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

(defn multiplicity
    [k n]
    (->>
        (range)
        (drop-while #(divides? (pow k (inc %)) n))
        (first)))

(defn prime-factorization
    [n]
    (->>
        (prime-factors n)
        (map #(vector % (multiplicity % n)))))

; Note that the problem statement is incorrect.
; The terms should be multiplied, not added.
(defn totient'
    [n]
    (->>
        (prime-factorization n)
        (map (fn [[p k]] (int (* (dec p) (pow p (dec k))))))
        (reduce *)))

(defn primes
    [low high]
    (filter prime? (range low (inc high))))

(defn goldbach
    [n]
    (->>
        (quot n 2)
        (primes 1)
        (drop-while #(not (prime? (- n %))))
        (first)
        (#(vector % (- n %)))))

(defn goldbach-list
    [low high]
    (->>
        (range low (inc high))
        (filter even?)
        (map goldbach)))
