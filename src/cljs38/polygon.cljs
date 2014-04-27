(ns cljs38.polygon)

; Calculate the distance between 2 points
(defn distance [a b]
  (Math/sqrt (+
             (Math/pow (- (a 0) (b 0)) 2)
             (Math/pow (- (a 1) (b 1)) 2))))

; Generate a polygon where all edges are equally distant
(defn coordinates [number-of-edges radius]
  (letfn [
    (edge-coordinates [index]
      [(* radius (Math/cos (/ (* index 2 Math/PI) number-of-edges)))
       (* radius (Math/sin (/ (* index 2 Math/PI) number-of-edges)))])

    (next-edge [edges-left, edges]
      (if (> edges-left 0)
        (next-edge (- edges-left 1) (conj edges (edge-coordinates edges-left)) )
        edges))]

    (next-edge number-of-edges [])))
