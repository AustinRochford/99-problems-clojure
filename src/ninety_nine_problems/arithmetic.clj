(ns ninety-nine-problems.arithmetic
    (:require
        [clojure.contrib.core :refer :all]
        [clojure.contrib.math :refer [exact-integer-sqrt floor]]
        [clojure.contrib.generic.math-functions :refer [pow]])
    (:gen-class))

; Helpers for Problem 31
(defn sqrt
    "Calculate the floor of the square root of n"
    [n]
    (nth (exact-integer-sqrt n) 0))

(defn divides?
    "Determine if k divides n"
    [k n]
    (zero? (mod n k)))

; Problem 31
(defn prime?
    "Determine if n is prime"
    [n]
    (if (= 1 n)
        false
        (->>
            (sqrt n)
            (inc)
            (range 2)
            (filter #(divides? % n))
            (empty?))))

; Problem 32
(defn gcd
    "Calculate the greatest commond divisor of two integers using Eclid's algorithm"
    [m n]
    (if (< m n)
        (recur n m)
    (if (zero? n)
        m
        (recur n (mod m n)))))

; Problem 33
(def coprime?
    "Determine if two numbers are coprime"
    (comp (partial = 1) gcd))

; Problem 34
(defn totient
    "Caclulate Euler's totient function"
    [n]
    (->> n
        (range 1)
        (filter (partial coprime? n))
        (count)))

; Helpers for Problem 36
(defn prime-factors
    "Calculate the prime factors of a number, without multiplicity"
    [n]
    (->> n
        (inc)
        (range 2)
        (filter #(and (divides? % n) (prime? %)))))

(defn multiplicity
    "Calculate the multiplicity of k as a divisor of n"
    [k n]
    (->>
        (range)
        (drop-while #(divides? (pow k (inc %)) n))
        (first)))

; Problem 36
(defn prime-factorization
    "Calculate the prime factorization of a number"
    [n]
    (->>
        (prime-factors n)
        (map #(vector % (multiplicity % n)))))


; Problem 37
; Note that the problem statement is incorrect.
; The terms should be multiplied, not added.
(defn totient'
    "Efficient calculation of Euler's totient function"
    [n]
    (->>
        (prime-factorization n)
        (map (fn [[p k]] (int (* (dec p) (pow p (dec k))))))
        (reduce *)))

; Problem 39
(defn primes
    "List the primes in a given range"
    [low high]
    (filter prime? (range low (inc high))))

; Problem 40
(defn goldbach
    "Find two primes that sum to the given (even) integer"
    [n]
    (->>
        (quot n 2)
        (primes 1)
        (drop-while #(not (prime? (- n %))))
        (first)
        (#(vector % (- n %)))))

; Problem 41
(defn goldbach-list
    "List Goldbach decompositions of even numbers in a given range"
    [low high]
    (->>
        (range low (inc high))
        (filter even?)
        (map goldbach)))
