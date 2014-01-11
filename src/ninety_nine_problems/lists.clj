(ns ninety-nine-problems.lists
    (:require
        [clojure.contrib.core :refer :all]
        [ninety-nine-problems.core :refer :all])
    (:gen-class))

; Problem 1
(defn last'
    "Get the last element of a list"
    [coll]
    (let
        [[head & tail] coll]
        (if (empty? tail)
            head
            (recur tail))))

; Problem 2
(defn but-last
    "Get the second-to-last element of a list"
    [coll]
    (let
        [[head snd & tail] coll]
        (if (nil? snd)
            nil
        (if (empty? tail)
            head
            (recur (conj tail snd))))))

; Problem 3
(defn element-at
    "Get the k-th element of a list, for a given k"
    [coll k]
    (if (empty? coll)
        nil
    (if (= k 1)
        (first coll)
        (recur (rest coll) (dec k)))))

; Problem 4
(def length
    "Calculate the length of a list"
    (comp
        (partial reduce +)
        (partial map (constantly 1))))

; Problem 5
(defn reverse'
    "Reverse a list"
    [coll]
    (if (empty? coll)
        '()
        (reduce conj '() coll)))

; Problem 6
(defn palindrome?
    "Determine whether or not a list is a palindrome"
    [coll]
    (= coll (reverse' coll)))

; Problem 7
(defn flatten'
    "Flatten a nested list structure"
    [coll]
    (if (empty? coll)
        '()
        (let [[head & tail] coll]
            (if (seq? head)
                (concat (flatten' head) (flatten' tail))
                (conj (flatten' tail) head)))))

; Problem 8
(def compress
    "Eliminate consecutive duplicates of list elements"
    (comp
        (partial map first)
        (partial partition-by identity)))

; Problem 9
(def pack 
    "Pack consecutive duplicates of list elements into sublists"
    (partial partition-by identity))

; Problem 10
(def encode 
    "Encode a list by listing the length of each run of consecutive idential elements"
    (comp
        (partial map #(vector (count %) (first %)))
        pack))

; Problem 11
(def encode'
    "Like Problem 10, except for elements with no duplicates are simply copied with no count"
    (comp
        (partial map
            (fn [coll]
                (let [[head & tail] coll]
                    (if (empty? tail)
                        head
                        [(count coll) head]))))
        pack))

; Problem 12
(def decode
    "Decode a list encoded using encode' from Problem 11"
    (partial mapcat
        (fn [encoded]
            (if (vector? encoded)
                (apply replicate encoded)
                `(~encoded)))))

; Problem 14
(def duplicate
    "Duplicate the elements of a list"
    (partial mapcat (partial replicate 2)))

; Problem 15
(defn replicate'
    "Replicate the elements of a list n times"
    [coll n]
    (mapcat (partial replicate n) coll))

; Problem 16
(defn drop-every
    "Drop every n-th element from the list"
    [coll n]
    (mapcat 
        (fn [part]
            (if (= (count part) n)
                (butlast part)
                part))
        (partition-all n coll)))

; Problem 17
(defn split
    "Split a list into two parts, given the length of the first"
    [coll n]
    (if (empty? coll)
        ['() '()]
    (if (zero? n)
        ['() coll]
        (let 
            [[head & tail]  coll
            [before after]  (split tail (dec n))]
            [(conj before head) after]))))

; Problem 18
(defn slice
    "Extract a slice from the list"
    [coll m n]
    (->> coll
        (drop (dec m))
        (take (inc (- n m)))))

; Problem 19
(defn rotate
    "Rotate a list n places to the left"
    [coll n]
    (let [length (count coll)]
        (if (neg? n)
            (recur coll (+ length n))
        (if (> n length)
            (recur coll (mod n length))
            (let [[before after] (split coll n)]
                (concat after before))))))

; Problem 20
(defn remove-at
    "Remove the element at a given position from a list"
    [coll n]
    (let [[before [_ & after]] (split coll (dec n))]
        (concat before after)))

; Problem 21
(defn insert-at
    "Insert an element at a given position in a list"
    [x coll n]
    (let [[before after] (split coll (dec n))]
        (if (empty? after)
            (if (= (count before) (dec n))
                (concat before (replicate 1 x))
                before)
            (concat before (conj after x)))))

; Problem 22
(defn range'
    "Create a list containing all the integers in a given range"
    [m n]
    (take (inc (- n m)) (iterate inc m)))

; Problem 26
(defn combinations
    "Generate the combinations of a given size from a list"
    [k coll]
    (if (zero? k)
        '(())
    (if (empty? coll)
        nil
        (let
            [[head & tail] coll
            with-head (combinations (dec k) tail)
            without-head (combinations k tail)]
            (concat (map #(conj % head) with-head) without-head)))))

; Problem 27
(defn group
    "Group elements of coll into disjoint subgroups with specified sizes"
    [coll groups]
    (if (empty? groups)
        '(())
        (let
            [[n & ns] groups
            heads (combinations n coll)]
            (mapcat
                (fn [head]
                    (map #(conj % head) (group (diff coll head) ns)))
                heads))))

; Problem 28a
(def sort-by-length
    "Sort a list of lists by length of the sublists"
    (partial sort-by count))

; Problem 28b
(defn sort-by-length-frequency
    "Sort a lsit of lists by the frequency of their length in the parent list"
    [coll]
    (let [freqs (frequencies (map count coll))]
        (sort-by #(freqs (count %)) coll)))
