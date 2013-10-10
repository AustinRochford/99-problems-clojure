(ns ninety-nine-problems.logic-codes
    (:require
        [clojure.contrib.core :refer :all])
    (:gen-class))

(defn gray-code
    [n]
    (if (= n 1)
        '((0) (1))
        (let [code (gray-code (dec n))]
            (concat
                (map #(conj % 0) code)
                (map #(conj % 1) (reverse code))))))
