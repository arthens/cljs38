(ns cljs38.game_test
  (:require-macros [cemerick.cljs.test :refer (is deftest)])
  (:require [cemerick.cljs.test :as test]
            [cljs38.validation :as validation]
            [cljs38.game :as game]))

; Test sum function

(deftest initial-game-not-won
  (is (= false (validation/won-game? 
                game/magic-number
                game/game-board
                game/rows))))