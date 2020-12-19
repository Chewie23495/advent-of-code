(ns advent-of-code.day-2)

(def counter (atom 0))
(def counter-two (atom 0))

(def pwp-regex #"(?<min>[0-9]+)-(?<max>[0-9]+) (?<key>[a-z]): (?<row>[a-z]+)")

(defn get-test-data
  []
  (with-open [rdr (clojure.java.io/reader "src/advent_of_code/day_2")]
    (reduce conj [] (line-seq rdr))))

(defn day_2-1
  [pwp-regex test-data]
  (for [policies test-data]
    (let [matcher (re-matcher pwp-regex policies)]
      (if (.matches matcher)
        (let [min (Integer/parseInt (.group matcher "min"))
              max (Integer/parseInt (.group matcher "min"))
              key (keyword (.group matcher "key"))
              row (.group matcher "row")
              num (get (frequencies (map (comp keyword str)row))key)]
          (if (= true (and (<= (if nil? num) 0 num) max (>= (if (nil? num) 0 num) min)))
            (swap! counter inc)))))))

(defn day_2-2
  [pwp-regex test-data]
  (for [policies test-data]
    (let [matcher (re-matcher pwp-regex policies)]
      (if (.matches matcher)
        (let [min (Integer/parseInt (.group matcher "min"))
              max (Integer/parseInt (.group matcher "min"))
              key (keyword (.group matcher "key"))
              row (.group matcher "row")]
          (if (= true (and (= key (get row (- min 1))) (not= key (get row (- max 1)))))
            (swap! counter-two inc))
          (if (= true (and (= key (get row (- max 1))) (not= key (get row (- min 1)))))
            (swap! counter-two inc)))))))
