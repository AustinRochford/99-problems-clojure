(ns ninety-nine-problems.trees-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.trees :refer :all]))

(deftest tree?-test-true
    (is (tree? [:a [:b nil nil] nil])))

(deftest tree?-test-false
    (is (not (tree? [:a [:b nil nil]]))))

(deftest same-tree?-test-nil-true
    (is (same-tree? nil nil)))

(deftest same-tree?-test-first-nil-false
    (is (not (same-tree? nil [:x nil nil]))))

(deftest same-tree?-test-second-nil-false
    (is (not (same-tree? [:x nil nil] nil))))

(deftest same-tree?-test-leaves-true
    (is (same-tree? [:x nil nil] [:y nil nil])))

(deftest same-tree-test-true-two
    (is (same-tree? [:x [:y nil nil] nil] [:a [:b nil nil] nil])))

(deftest same-tree-test-false-two
    (is (not (same-tree? [:x [:y nil nil] nil] [:x nil [:y nil nil]]))))

(deftest symmetric?-nil
    (is (symmetric? nil)))

(deftest symmetric?-one
    (is (symmetric? [:x nil nil])))

(deftest symmetric?-two
    (is (not (symmetric? [:x [:y nil nil] nil]))))

(deftest symmetric?-three
    (is (symmetric? [:x [:y nil nil] [:z nil nil]])))

(deftest symmetric?-four
    (is (not (symmetric? [:x [:y nil nil] [:z nil [:a nil nil]]]))))

(deftest symmetric?-true-five
    (is (symmetric? [:x [:y nil [:z nil nil]] [:a nil [:b nil nil]]])))

(deftest symmetric?-false-five
    (is (not (symmetric? [:x [:y nil [:z nil nil]] [:a [:b nil nil] nil]]))))
