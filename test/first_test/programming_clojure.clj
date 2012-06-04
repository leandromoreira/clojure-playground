(ns first-test.programming-clojure
  (:use midje.sweet))

(fact
  "Almost every single thing acts like a function"
  (instance? clojure.lang.AFn [\a "a" :a] ) => truthy)

