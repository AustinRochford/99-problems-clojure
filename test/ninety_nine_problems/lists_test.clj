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
    (is (= nil (but-last '()))))

(deftest but-last-test-single
    (is (= nil (but-last '(1)))))
