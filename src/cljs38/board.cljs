(ns cljs38.board)

;; Initial values
;;
;;   9 10 11
;; 8 14 13 12
;;7 15 19 18 1
;; 6 16 17 2
;;   5 4 3
(def initial-values (list 9 10 11 8 14 13 12 7 15 19 18 1 6 16 17 2 5 4 3))

;; Board indexes:
;;
;;    00 01 02
;;  03 04 05 06
;; 07 08 09 10 11
;;  12 13 14 15
;;    16 17 18
(def game-board initial-values)

;; Rows indexes
(def rows 
	(list
		;; horizontal rows
		(list 0 1 2)
		(list 3 4 5 6)
		(list 7 8 9 10 11)
		(list 12 13 14 15)
		(list 16 17 18)

		;; SW -> NE rows
		(list 7 3 0)
		(list 12 8 4 1)
		(list 16 13 9 5 2)
		(list 17 14 10 6)
		(list 18 15 11)

		;; NW -> SE rows
		(list 7 12 16)
		(list 3 8 13 17)
		(list 0 4 9 14 18)
		(list 1 5 10 15)
		(list 2 6 11)))