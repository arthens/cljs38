(ns cljs38.validation)

(defn sum [values]
    (reduce + values))

(defn sum-to? [expected, values]
    (= expected (sum values)))

(defn get-row [board, indexes]
    (map (partial nth board) indexes))

(defn is-valid-row? [expected, board, row]
    (sum-to? expected (get-row board row)))

(defn won-game? [expected, board, rows]
  (letfn [
    (validate-row [row]
        (is-valid-row? expected board row))

    (validate-rows []
        (map validate-row rows))

    (all-rows-valid? [results]
        (every? true? results))]

    (all-rows-valid? (validate-rows))))