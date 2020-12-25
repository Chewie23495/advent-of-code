(ns advent-of-code.day-3)

(def test-data
  (clojure.string/split-lines (slurp "src/advent_of_code/day_3.txt")))

(defn day_3-1
  [test-data x y]
  (->> (for [i (range)
             :let [x' (* x i) y' (* y i)]
             :while (< y' (count test-data))]
         [y' (mod x' (count (first test-data)))])
      (filter #(= (get-in test-data %) \#))
      count))


(defn day_3-2 [test-data]
  (apply * (map #(apply day_3-1 test-data %)
                [[1 1] [3 1] [5 1] [7 1] [1 2]])))

