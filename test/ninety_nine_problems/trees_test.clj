(ns ninety-nine-problems.trees-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.trees :refer :all]))

(deftest tree?-test-true
    (is (tree? [:a [:b nil nil] nil])))

(deftest tree?-test-false
    (is (not (tree? [:a [:b nil nil]]))))
