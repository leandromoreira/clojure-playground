(ns first-test.test.core
  (:use clojure.test)
  (:use midje.sweet))

(deftest simple-facts
         (fact 
           (+ 1 0) => 1
           (* 1 1) => 1))

(deftest creating-sequences
         (fact
           "Ranges creates ranges, doh!"
           (range 2) => '(0 1)
           (range 0 3) => '(0 1 2)
           (range 0 10 2) => '(0 2 4 6 8)))
