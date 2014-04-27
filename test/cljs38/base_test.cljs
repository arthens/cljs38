(ns cljs38.test
  (:require-macros [cemerick.cljs.test :refer (is deftest)])
  (:require [cemerick.cljs.test :as test]))

(deftest base-test
  (is (= 3 (+ 2 1))))
