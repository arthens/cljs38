(ns cljs38.validation_test
  (:require-macros [cemerick.cljs.test :refer (is deftest)])
  (:require [cemerick.cljs.test :as test]
            [cljs38.validation :as validation]))

;; Test sum function

(deftest sum-10
  (is (= 10 (validation/sum (list 1 2 3 4)))))

(deftest sum-38
  (is (= 38 (validation/sum (list 15 10 3 4 6)))))


;; Test sum validation

(deftest sum-to-with-4
  (is (= true (validation/sum-to? 10 (list 1 2 3 4)))))

(deftest sum-to-with-5
  (is (= true (validation/sum-to? 38 (list 28 1 2 3 4)))))

(deftest not-sum-to-with-4
  (is (= false (validation/sum-to? 10 (list 1 2 3 5)))))

(deftest not-sum-to-with-5
  (is (= false (validation/sum-to? 20 (list 28 1 2 3 4)))))


;; Test data

(def test-board (list 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15))

;; Test extract row
(deftest extract-row
  (is (= (list 1 3 5) 
         (validation/get-row 
            test-board
            (list 0 2 4)))))


;; Test is valid row

(deftest valid-row-1
  (is (= true (validation/is-valid-row? 
                38
                test-board
                (list 14 13 8)))))

(deftest invalid-row-1
  (is (= false (validation/is-valid-row? 
                38
                test-board
                (list 14 13 7)))))


;; Test won game

(deftest won-game
  (is (= true (validation/won-game? 
                38
                test-board
                (list
                  (list 14 13 8)
                  (list 14 12 9))))))

(deftest no-twon-game
  (is (= false (validation/won-game? 
                38
                test-board
                (list
                  (list 14 13 8)
                  (list 14 12 8))))))
