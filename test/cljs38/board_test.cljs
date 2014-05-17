(ns cljs38.board_test
  (:require-macros [cemerick.cljs.test :refer (is deftest)])
  (:require [cemerick.cljs.test :as test]
            [cljs38.validation :as validation]
            [cljs38.board :as board]))

; Test sum function

(deftest initial-game-not-won
  (is (= false (validation/won-game? 
                38
                (board/game-board)
                (board/rows)))))