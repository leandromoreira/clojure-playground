(ns first-test.test.core
  (:use clojure.test)
  (:use midje.sweet))

(deftest simple-facts
         (fact 
           (+ 1 0) => 1
           (* 1 1) => 1))
