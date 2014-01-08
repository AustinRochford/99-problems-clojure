(ns ninety-nine-problems.logic-codes-test
    (:require
        [clojure.test :refer :all]
        [clojure.data.priority-map :refer :all]
        [ninety-nine-problems.logic-codes :refer :all]))

(deftest gray-code-test-one
    (is (= '((0) (1)) (gray-code 1))))

(deftest gray-code-test-two
    (is (= '((0 0) (0 1) (1 1) (1 0)) (gray-code 2))))

(deftest gray-code-test-three
    (is (= '((0 0 0) (0 0 1) (0 1 1) (0 1 0) (1 1 0) (1 1 1) (1 0 1) (1 0 0)) (gray-code 3))))

(deftest merge-trees-test
    (is (= ['(nil :a :b) 3] (merge-trees [:a 2] [:b 1]))))

(deftest pop'-test-two
    (is (= ['([:b 1] [:c 3]) {:a 4 :d 6}] (pop' 2 (priority-map :a 4 :b 1 :c 3 :d 6)))))

(deftest pop'-test-three
    (is (= ['([:b 1] [:c 3] [:a 4]) {:d 6}] (pop' 3 (priority-map :a 4 :b 1 :c 3 :d 6)))))

(deftest huffman-tree-test
    (is (= ['(nil :b :a) 3] (huffman-tree (priority-map :a 2 :b 1)))))

(deftest huffman-tree-test-three
    (is (= ['(nil (nil :b :a) :c) 7] (huffman-tree (priority-map :a 2 :b 1 :c 4)))))

(deftest huffman-tree-test-four
    (is (= ['(nil (nil :a :b) (nil :c :d)) 22] (huffman-tree (priority-map :a 4 :b 5 :c 6 :d 7)))))

(deftest huffman-code-from-tree-test
    (is (= {:a '(1), :b '(0)} (huffman-code-from-tree '(nil :b :a)))))

(deftest huffman-code-from-tree-test-three
    (is (= {:c '(1), :a '(0 1), :b '(0 0)} (huffman-code-from-tree '(nil (nil :b :a) :c)))))

(deftest huffman-code-test
    (is (=
        {:a '(0), :b '(1, 0, 1), :c '(1, 0, 0), :d '(1, 1, 1), :e '(1, 1, 0, 1), :f '(1, 1, 0, 0)}
        (huffman-code (priority-map :a 45 :b 13 :c 12 :d 16 :e 9 :f 5)))))
