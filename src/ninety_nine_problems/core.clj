(ns ninety-nine-problems.core
  (:gen-class))

(defn elem?
    "Determine if x is in coll"
    [x coll]
    (some #{x} coll))

(defn diff
    "Remove all elements of coll' from coll"
    [coll coll']
    (filter #(not (elem? % coll')) coll))
