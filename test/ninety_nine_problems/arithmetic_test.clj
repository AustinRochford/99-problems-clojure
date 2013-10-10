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

(deftest gcd-test
    (is (= '(1 2 12 1) (map gcd '(2 2 36 19) '(3 4 48 100)))))

(deftest coprime?-test
    (is (= '(true false) (map coprime? '(2 6) '(3 9)))))

(deftest totient-test
    (is (= '(6 4 12) (map totient '(9 10 13)))))

(deftest prime-factors-test-six
    (is (= '(2 3) (prime-factors 6))))

(deftest prime-factors-seven
    (is (= '(7) (prime-factors 7))))

(deftest prime-factors-sixty
    (is (= '(2 3 5) (prime-factors 60))))

(deftest multiplicity-test
    (is (= '(0 1 2 1 2) (map multiplicity '(2 2 2 3 4) '(3 2 4 12 32)))))

(deftest prime-factorization-test-six
    (is (= '([2 1] [3 1]) (prime-factorization 6))))

(deftest prime-factorization-seven
    (is (= '([7 1]) (prime-factorization 7))))

(deftest prime-factorization-twenty-seven
    (is (= '([3 3]) (prime-factorization 27))))

(deftest prime-factorization-sixty
    (is (= '([2 2] [3 1] [5 1]) (prime-factorization 60))))
