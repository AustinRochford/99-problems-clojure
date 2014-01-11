(ns ninety-nine-problems.miscellaneous-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.miscellaneous :refer :all]))

(deftest diagonal-threat-test
    (is (= '(true true true true false false) (map (partial diagonal-threat [4 4]) '([1 1] [6 6] [3 5] [5 3] [1 2] [4 6])))))

(deftest no-diagonal-threats-test-two-false
    (is (not (no-diagonal-threats [1 2]))))

(deftest no-diagonal-threats-test-two-true
    (is (no-diagonal-threats [1 1])))

; This test uses a known solution to the eight queens problem
(deftest no-diagonal-threats-test-eight-true
    (is (no-diagonal-threats [5 3 1 7 2 8 6 4])))

; Number of solutions taken from Wikipedia:
; http://en.wikipedia.org/wiki/Eight_queens_puzzle#Counting_solutions
(deftest one-queen-count-test
    (is (= 1 (count (queens 1)))))

(deftest two-queens-count-test
    (is (zero? (count (queens 2)))))

(deftest three-queens-count-test
    (is (zero? (count (queens 3)))))

(deftest four-queens-count-test
    (is (= 2 (count (queens 4)))))

(deftest five-queens-count-test
    (is (= 10 (count (queens 5)))))

(deftest six-queens-count-test
    (is (= 4 (count (queens 6)))))

(deftest seven-queens-count-test
    (is (= 40 (count (queens 7)))))

(deftest eight-queens-count-test
    (is (= 92 (count (queens 8)))))

(deftest eight-queens-test
    (is (every? no-diagonal-threats (queens 8))))
