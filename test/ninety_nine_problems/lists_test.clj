(ns ninety-nine-problems.lists-test
    (:require
        [clojure.test :refer :all]
        [ninety-nine-problems.lists :refer :all]))

(deftest last'-test
    (is (= 3 (last' '(1 2 3)))))

(deftest last'-test-empty
    (is (nil? (last' '()))))

(deftest last'-test-singleton
    (is (= 1 (last' '(1)))))

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

(deftest drop-every-test
    (is (= '(1 2 4 5) (drop-every '(1 2 3 4 5 6) 3))))

(deftest drop-every-uneven
    (is (= '(1 2 4 5 7) (drop-every '(1 2 3 4 5 6 7) 3))))

(deftest drop-every-test-one
    (is (empty? (drop-every '(1 2 3) 1))))

(deftest split-test
    (is (= ['(1) '(2 3)] (split '(1 2 3) 1))))

(deftest split-test-two
    (is (= ['(1 2) '(3)] (split '(1 2 3) 2))))

(deftest split-test-three
    (is (= ['(1 2 3) '()] (split '(1 2 3) 3))))

(deftest split-test-zero
    (is (= ['() '(1 2 3)] (split '(1 2 3) 0))))

(deftest split-test-too-long
    (is (= ['(1 2 3) '()] (split '(1 2 3) 4))))

(deftest slice-test
    (is (= '(2 3 4) (slice '(1 2 3 4 5) 2 4))))

(deftest slice-test-first
    (is (= '(1 2 3) (slice '(1 2 3 4 5) 1 3))))

(deftest slice-test-last
    (is (= '(4 5) (slice '(1 2 3 4 5) 4 5))))

(deftest slice-test-single
    (is (= '(3) (slice '(1 2 3 4 5) 3 3))))

(deftest slice-test-too-long
    (is (= '(3 4 5) (slice '(1 2 3 4 5) 3 6))))

(deftest slice-test-too-big
    (is (empty? (slice '(1 2 3 4 5) 6 7))))

(deftest rotate-test
    (is (= '(4 5 6 7 8 1 2 3) (rotate '(1 2 3 4 5 6 7 8) 3))))

(deftest rotate-test-zero
    (is (= '(1 2 3) (rotate '(1 2 3) 0))))

(deftest rotate-test-length
    (is (= '(1 2 3) (rotate '(1 2 3) 3))))

(deftest rotate-test-negative
    (is (= '(7 8 1 2 3 4 5 6) (rotate '(1 2 3 4 5 6 7 8) -2))))

(deftest rotate-test-more-than-length
    (is (= '(2 3 1) (rotate '(1 2 3) 4))))

(deftest remove-at-test
    (is (= '(1 3) (remove-at '(1 2 3) 2))))

(deftest remove-at-first
    (is (= '(2 3) (remove-at '(1 2 3) 1))))

(deftest remove-at-last
    (is (= '(1 2) (remove-at '(1 2 3) 3))))

(deftest remove-at-too-big
    (is (= '(1 2 3) (remove-at '(1 2 3) 4))))

(deftest insert-at-test
    (is (= '(1 2 3) (insert-at 2 '(1 3) 2))))

(deftest insert-at-test-first
    (is (= '(1 2 3) (insert-at 1 '(2 3) 1))))

(deftest insert-at-test-last
    (is (= '(1 2 3) (insert-at 3 '(1 2) 3))))

(deftest insert-at-test-empty
    (is (= '(1) (insert-at 1 '() 1))))

(deftest insert-at-test-too-big
    (is (= '(1 2 3) (insert-at 5 '(1 2 3) 5))))

(deftest range'-test
    (is (= '(2 3 4) (range' 2 4))))

(deftest range'-test-single
    (is (= '(3) (range' 3 3))))

(deftest combinations-test
    (is (= '((1 2) (1 3) (2 3)) (combinations 2 '(1 2 3)))))

(deftest combinations-test-singles
    (is (= '((1) (2) (3)) (combinations 1 '(1 2 3)))))

(deftest combinations-test-all
    (is (= '((1 2 3)) (combinations 3 '(1 2 3)))))

(deftest group-test
    (is (= '(((1) (2 3)) ((2) (1 3)) ((3) (1 2))) (group '(1 2 3) '(1 2)))))

(deftest group-test-fewer
    (is (= '(((1) (2)) ((1) (3)) ((2) (1)) ((2) (3)) ((3) (1)) ((3) (2))) (group '(1 2 3) '(1 1)))))

(deftest group-test-all
    (is (= '(((1 2 3))) (group '(1 2 3) '(3)))))

(deftest sort-by-length-test
    (is (= '((1) (2 2) (3 3 3)) (sort-by-length '((2 2) (1) (3 3 3))))))

(deftest sort-by-length-frequency-test
    (is (= '((1) (2 2) (2 2)) (sort-by-length-frequency '((2 2) (1) (2 2))))))

(deftest sort-by-lenth-frequency-test-two
    (is (= '((3 3 3) (3 3 3) (2 2) (2 2) (2 2) (1) (1) (1) (1)) (sort-by-length-frequency '((2 2) (3 3 3) (1) (2 2) (1) (3 3 3) (1) (1) (2 2))))))
