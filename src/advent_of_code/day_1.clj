(ns advent-of-code.day-1)

(defn day_1-1
  [numbers]
  (for [x numbers
        y numbers
        :let [z (+ x y)]
        :when (= z 2020)]
    (* x y)))

(defn day_1-2
  [numbers]
  (for [x numbers
        y numbers
        z numbers
        :let [q (+ x y z)]
        :when (= q 2020)]
    (* x y z)))
