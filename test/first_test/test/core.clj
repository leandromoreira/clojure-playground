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

(deftest transforming-seq
         (fact
           (map #(inc %) [2 3]) => '(3 4)
           (map #(format "<li>%s</li>" %) '("r" "b"))
                => '("<li>r</li>" "<li>b</li>")
           (reduce + [1 2 3 4]) => 10
           (sort [12 8 9 90 1]) => [1 8 9 12 90]
           (sort-by #(.toString %) [1 10 2 3]) => [1 10 2 3]
           (sort-by :name [ {:name "mario" :color "red"} 
                           {:name "luigui" :color "green"}
                           {:name "yoshi" :color "blue"} ]
                    ) => (contains {:name "mario" :color "red"})))
(use 'clojure.set)
(deftest set-operations
         (def letters #{"a" "b"})
         (def numbers #{1 2})
         (def mix #{"a" 3 :four})
         (fact
           (union letters numbers) => #{"a" "b" 1 2}
           (difference letters mix) => #{ "b" }
           (intersection letters mix) => #{ "a" }
           (select even? numbers) => #{2}))
