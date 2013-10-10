(ns ninety-nine-problems.logic-codes-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.logic-codes :refer :all]))

(deftest gray-code-test-one
    (is (= '((0) (1)) (gray-code 1))))

(deftest gray-code-test-two
    (is (= '((0 0) (0 1) (1 1) (1 0)) (gray-code 2))))

(deftest gray-code-test-three
    (is (= '((0 0 0) (0 0 1) (0 1 1) (0 1 0) (1 1 0) (1 1 1) (1 0 1) (1 0 0)) (gray-code 3))))
