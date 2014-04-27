(ns cljs38.polygon_test
  (:require-macros [cemerick.cljs.test :refer (is deftest)])
  (:require [cemerick.cljs.test :as test]
            [cljs38.polygon :as polygon]))

;; Test functions

; Function that test approximation with a tolerance of 1%
(defn close? [x y]
  (< (Math/abs (- x y)) (* x 0.01)))

; Functions that check the distance of all edges of a polygon
(defn points-have-equal-distance? [coordinates]
  (let [
    expected (polygon/distance (coordinates 0) (coordinates 1))
    recursive-check (fn [index]
      (if (= index (- (count coordinates) 1))
        (close? expected (polygon/distance (coordinates index) (coordinates 0)))
        (and (close? expected (polygon/distance (coordinates index) (coordinates (+ index 1)))))))]

    (recursive-check 0)))


; Test distance method
(deftest points-distance-x
  (is (= 2 (polygon/distance [2 1] [4 1]))))

(deftest points-distance-y
  (is (= 4 (polygon/distance [1 -1] [1 3]))))

(deftest points-distance-x-y
  (is (close? 6.4 (polygon/distance [1 1] [5 6]))))


; Test that the number of edges is correct
(deftest triangles-has-3-edges
  (is (= 3 (count (polygon/coordinates 3 20)))))

(deftest square-has-4-edges
  (is (= 4 (count (polygon/coordinates 4 20)))))

(deftest hexagon-has-6-edges
  (is (= 6 (count (polygon/coordinates 6 20)))))


; Test that all edges are equally distant
(deftest triangle-edges-are-equally-distant
  (is (points-have-equal-distance? (polygon/coordinates 3 30))))

(deftest square-edges-are-equally-distant
  (is (points-have-equal-distance? (polygon/coordinates 4 30))))

(deftest hexagon-edges-are-equally-distant
  (is (points-have-equal-distance? (polygon/coordinates 6 30))))
