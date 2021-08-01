(ns cloj-todo.server.todo-controller
  (:require [cloj-todo.data.todo-queries :as query]))

(defn all
  []
  (query/all))

(defn get-by-id
  [id filter]
  (print (str "Id: " id " Filter: " filter))
  (let [result (query/get-by-id id)]
    (if (nil? result) 
      {} 
      result)))

(defn create
  [todo]
  (print (str todo))
  (query/insert todo))

(defn delete
  [id]
  (println "Delete" id)
  (query/delete id))

(defn update-todo 
  [todo]
  (query/update-todo todo))