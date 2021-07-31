(ns cloj-todo.data.todo-queries
  (:require [clojure.java.jdbc :as db]
            [cloj-todo.database :as db-config]))

(defn all []
  (db/query db-config/spec "select * from todo"))

(defn get-by-id 
  [id]
  (db/get-by-id db-config/spec :todo id :todo_id))

;{:description "Seed the database"}
(defn insert 
  [todo]
  (db/insert! db-config/spec :todo todo)
)

(defn update
  [todo]
  (db/update! db-config/spec :todo todo))

(defn delete
  [id]
  ((db/delete! db-config/spec :todo ["todo_id = ?" id])))



