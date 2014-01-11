(ns ninety-nine-problems.core-test
  (:require [clojure.test :refer :all]
            [ninety-nine-problems.core :refer :all]))

(deftest elem?-test-true
    (is (elem? 1 '(1 2 3))))

(deftest elem?-test-false
    (is (not (elem? 4 '(1 2 3)))))

(deftest diff-test
    (is (= '(1 2) (diff '(1 2 3 4) '(3 4)))))

(deftest diff-test-not-subset
    (is (= '(2 3 4) (diff '(1 2 3 4) '(0 1)))))

(deftest diff-test-disjoint
    (is (= '(1 2 3) (diff '(1 2 3) '(0 4)))))
