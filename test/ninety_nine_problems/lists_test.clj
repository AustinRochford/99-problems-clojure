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

(deftest flatten'-test
    (is (= '(1 2 3) (flatten' '((1) (2 (3)))))))

(deftest flatten'-test-flat
    (is (= '(1 2 3) (flatten' '(1 2 3)))))

(deftest compress-test
    (is (= '(1 2 3) (compress '(1 2 2 3 3 3)))))

(deftest compress-test-compressed
    (is (= '(1 2 3) (compress '(1 2 3)))))

(deftest compress-test-repeat
    (is (= '(1 2 1) (compress '(1 1 2 1 1)))))

(deftest pack-test
    (is (= '((1) (2 2) (3 3 3)) (pack '(1 2 2 3 3 3)))))

(deftest pack-test-singles
    (is (= '((1) (2) (3)) (pack '(1 2 3)))))

(deftest pack-test-repeat
    (is (= '((1 1) (2) (1 1)) (pack '(1 1 2 1 1)))))

(deftest encode-test
    (is (= '([1 1] [2 2] [3 3]) (encode '(1 2 2 3 3 3)))))

(deftest encode-test-singles
    (is (= '([1 1] [1 2] [1 3]) (encode '(1 2 3)))))

(deftest encode-test-repeat
    (is (= '([2 1] [1 2] [2 1]) (encode '(1 1 2 1 1)))))

(deftest encode'-test
    (is (= '(1 [2 2] [3 3]) (encode' '(1 2 2 3 3 3)))))

(deftest encode'-test-singles
    (is (= '(1 2 3) (encode' '(1 2 3)))))

(deftest ecnode'-test-repeat
    (is (= '([2 1] 2 [2 1]) (encode' '(1 1 2 1 1)))))

(deftest decode-test
    (is (= '(1 2 2 3 3 3) (decode '(1 [2 2] [3 3])))))

(deftest decode-test-singles
    (is (= '(1 2 3) (decode '(1 2 3)))))

(deftest decode-test-repeat
    (is (= '(1 1 2 1 1) (decode '([2 1] 2 [2 1])))))

(deftest duplicate-test
    (is (= '(1 1 2 2 3 3) (duplicate '(1 2 3)))))

(deftest duplicate-test-empty
    (is (= '() (duplicate '()))))

(deftest duplicate-test-duplicate
    (is (= '(1 1 1 1) (duplicate '(1 1)))))

(deftest replicate'-test
    (is (= '(1 1 1 2 2 2 3 3 3) (replicate' '(1 2 3) 3))))

(deftest replicate'-test-empty
    (is (= '() (replicate' '() 2))))

(deftest replicate'-test-zero
    (is (= '() (replicate' '(1 2 3) 0))))

(deftest replicate'-test-duplicate
    (is (= '(1 1 1 1 1 1) (replicate' '(1 1) 3))))
