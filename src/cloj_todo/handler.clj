(ns cloj-todo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [compojure.handler :as handler]
            [clojure.data.json :as json]
            [cloj-todo.server.todo-controller :as todo]))


(defroutes app-routes
  (GET "/" [] "Server Started")
  (POST "/" {body :body} (json/write-str body))
  (GET "/todo" [] (todo/all))
  (GET "/todo/:id{[0-9]+}" [id filter] (json/write-str (todo/get-by-id id filter)))
  (POST "/todo" {body :body} (todo/create body))
  (PUT "/todo" {body :body} (todo/update-todo body))
  (DELETE "/todo" {body :body} (todo/delete (:id body)))
  (route/not-found "404 Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body {:keywords? true})
      (middleware/wrap-json-response)))
