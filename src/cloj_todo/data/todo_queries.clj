(ns cloj-todo.data.todo-queries
  (:require [clojure.java.jdbc :as db]
            [cloj-todo.data.config :as db-config]))


(defn all []
  (try (db/query db-config/spec "select * from todo")
       (catch Exception e
         (print (str e))
         nil)))

(defn get-by-id
  [id]
  (try
    (db/get-by-id db-config/spec :todo id :todo_id)
    (catch Exception e
      (print (str e))
      nil)))

(defn insert
  [todo]
  (try
    (db/insert! db-config/spec :todo todo)
    (catch Exception e
      (print (str e))
      nil)))

(defn update-todo
  [todo]
  (try
    (let [id (todo :todo_id)
          updateable-fields (dissoc todo :todo_id :created_on)]
      (println "id:" id "\nmap:" updateable-fields)
      (db/update! db-config/spec :todo updateable-fields ["todo_id = ?" id]))
      (catch Exception e
        (print (str e))
        nil)))

(defn delete
  [id]
  (try
    (db/delete! db-config/spec :todo ["todo_id = ?" id])
    (catch Exception e
      (print (str e))
      nil)))
