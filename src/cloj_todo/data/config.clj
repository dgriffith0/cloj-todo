(ns cloj-todo.database)

(def spec
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname ".lsp/sqlite.db"})
