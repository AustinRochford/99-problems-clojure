(ns ninety-nine-problems.trees
    (:require
        [clojure.contrib.core :refer :all]
        [ninety-nine-problems.core :refer :all])
    (:gen-class))

; Problem 54A
(defn tree?
    "Check wether a given expression is a valid binary tree"
    [tree]
    (or
        (nil? tree)
        (if (= 3 (count tree))
            (let [[_ left right] tree]
                (and (tree? left) (tree? right))))))

; Helpers for Problem 56
(defn same-tree?
    "Determine whether or not two trees are the same in terms of shape"
    [tree1 tree2]
    (if (and (nil? tree1) (nil? tree2))
        true
    (if (or (nil? tree1) (nil? tree2))
        false
        (let
            [[_ left1 right1] tree1
            [_ left2 right2] tree2]
            (and
                (same-tree? left1 left2)
                (same-tree? right1 right2))))))

; Problem 56
(defn symmetric?
    "Determine whether or not a tree is symmetric"
    [tree]
    (or
        (nil? tree)
        (let [[_ left right] tree]
            (same-tree? left right))))

; Helpers for Problem 57
(defn bst-add
    "Add an element to a binary search tree"
    [tree x]
    (if (nil? tree)
        [x nil nil]
        (let [[y left right] tree]
            (if (< x y)
                [y (bst-add left x) right]
                [y left (bst-add right x)]))))

; Problem 57
(def bst
    "Build a binary search tree from a list of values"
    (partial reduce bst-add nil))

; Helpers for Problem 61
(defn leaf?
    "Determine whether or not a tree is a leaf"
    [tree]
    (and
        (not (nil? tree))
        (let [[_ left right] tree]
            (and
                (nil? left)
                (nil? right)))))

; Problem 61
(defn count-leaves
    "Count the leaves of a binary tree"
    [tree]
    (if (nil? tree)
        0
    (if (leaf? tree)
        1
        (let [[_ left right] tree]
            (+
                (count-leaves left)
                (count-leaves right))))))

; Problem 61A
(defn leaves
    "Collect the leaves of a binary tree in a list"
    [tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (if (leaf? tree)
                (list x)
                (concat
                    (leaves left)
                    (leaves right))))))

; Problem 62
(defn internals
    "Collect the internal (non-leaf) nodes of a binary tee in a list"
    [tree]
    (if (or (nil? tree) (leaf? tree))
        '()
        (let [[x left right] tree]
            (list* x
                (concat
                    (internals left)
                    (internals right))))))

; Problem 62B
(defn at-level
    "Collect the nodes at a given level in a list"
    [n tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (if (= 1 n)
                (list x)
                (concat
                    (at-level (dec n) left)
                    (at-level (dec n) right))))))

; Problem 68A
(defn preorder
    "Preorder traversal of a tree"
    [tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (concat
                (conj (preorder left) x)
                (preorder right)))))

(defn inorder
    "Inorder traversal of a tree"
    [tree]
    (if (nil? tree)
        '()
        (let [[x left right] tree]
            (concat
                (inorder left)
                (conj (inorder right) x)))))

; Problem 68B
; Note that we assume there are no duplicate entries in the tree
(defn tree-from-traversals
    "Reconstruct a tree from its preorder and inorder traversals"
    [pre in]
    (if (or (empty? pre) (empty? in))
        nil
        (let
            [[root & pre-tail] pre
             [in-before [_ & in-after]] (split-with #(not (= % root)) in)
             pre-before (diff pre-tail in-after)
             pre-after (diff pre-tail in-before)]
            [root
                (tree-from-traversals pre-before in-before)
                (tree-from-traversals pre-after in-after)])))
