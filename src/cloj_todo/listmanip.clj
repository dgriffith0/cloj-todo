(ns cloj-todo.listmanip)

(def data [{:id 1
            :text "hfrtyhfgh"
            :valid false}
           {:id 2
            :text "sefsfs"
            :valid true}
           {:id 3
            :text "32323"
            :valid false}
           {:id 4
            :text "cvbcvb"
            :valid true}
           {:id 5
            :text "liuouio"
            :valid false}])

(def item {:id 1
           :text "hfrtyhfgh"})

item
data

(assoc item :added "this")

(map (fn [x] (assoc x :added "this")) data)

(map #(assoc % :added "this") data)

(into (map #(dissoc % :id) data) {:text "SOMETHING I ADDED"})

(filter #(> (:id %) 2) data)

(->>
 data
 (filter #(> (:id %) 2))
 (filter #(true? (:valid %)))
 (map #(assoc % :added "this"))
 )

