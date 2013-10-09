(ns ninety-nine-problems.lists-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.lists :refer :all]))

(deftest last'-test
    (is (= 3 (last' '(1 2 3)))))

(deftest last'-test-empty
    (is (nil? (last' '()))))

(deftest but-last-test
    (is (= 2 (but-last '(1 2 3)))))

(deftest but-last-test-empty
    (is (nil? (but-last '()))))

(deftest but-last-test-single
    (is (nil? (but-last '(1)))))

(deftest element-at-test-one
    (is (= 1 (element-at '(1 2 3) 1))))

(deftest element-at-test-two
    (is (= 2 (element-at '(1 2 3) 2))))

(deftest element-at-test-three
    (is (= 3 (element-at '(1 2 3) 3))))

(deftest element-at-test-empty
    (is (nil? (element-at '() 1))))

(deftest element-at-test-too-small
    (is (nil? (element-at '(1 2) 3))))

(deftest length-test-one
    (is (= 1 (length '(1)))))

(deftest length-test-two
    (is (= 2 (length '(1 2)))))

(deftest length-test-empty
    (is (zero? (length '()))))

(deftest length-test-large
    (is (= 100 (length (range 100)))))

(deftest reverse'-test
    (is (= '(3 2 1) (reverse' '(1 2 3)))))

(deftest reverse'-test-empty
    (is (empty? (reverse' '()))))

(deftest palindrome?-test
    (is (palindrome? '(1 2 1))))

(deftest palindrome?-test-long
    (is (palindrome? '(1 2 1 3 4 3 1 2 1))))

(deftest palindrome?-test-empty
    (is (palindrome? '())))

(deftest palindrome?-test-false
    (is (not (palindrome? '(1 2 3 2)))))
