(ns ninety-nine-problems.arithmetic-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.arithmetic :refer :all]))

(deftest sqrt-test
    (is (= '(1 1 2 2) (map sqrt '(2 3 4 5)))))

(deftest divides-test
    (is (= '(true false true false) (map divides? '(2 2 3 3) '(2 3 6 7)))))

(deftest prime?-test
    (is (= '(true true false true false true) (map prime? '(2 3 4 5 6 7)))))
