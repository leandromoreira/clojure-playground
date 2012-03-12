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
           (range 0 10 2) => '(0 2 4 6 8))
         (fact
           "Repeat something x times"
           (repeat 3 :sol) => '(:sol :sol :sol))
         (fact
           "Repeat returns a lazy infite sequence"
           (take 3 (repeat :sol)) => '(:sol :sol :sol))
         (fact
           "Iterate a function over a value"
           (take 2 (iterate inc 1)) => '(1 2))
         (fact
           "Cycle also produces a infinite sequence"
           (take 3 (repeat :sol)) => '(:sol :sol :sol))
         (fact
           "Interleave collections"
           (interleave [:a :b] [1 2]) => '(:a 1 :b 2)
           (interleave [:a :b] [1 2 3]) => '(:a 1 :b 2)))

(deftest filter-sequences
         (def fruits '("avocato" "orange" "apple"))
         (fact
           "Filter uses a predicate over a collection"
           (filter #(.startsWith % "a") fruits) => '("avocato" "apple")
           (filter odd? #{1 2 3 4}) => '(1 3)
           (take-while #(< % 3) (iterate inc 1)) => '(1 2)
           (drop-while even? '(2 4 5 6 90 100)) => '(5 6 90 100)
           (every? odd? [1 3 5]) => truthy
           (some even? [1 3 5]) => falsey
           (some #(instance? String %) '(1 2 3 "me")) => truthy
           (not-any? even? [1 3 5 9]) => truthy

           ))
