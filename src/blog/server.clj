(ns blog.server
  (:require [blog.models.mongo :as mongo])
  (:require [noir.server :as server]))

(server/load-views "src/blog/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (mongo/connect!)
    (server/start port {:mode mode
                        :ns 'blog})))

