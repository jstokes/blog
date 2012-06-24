(ns blog.server
  (:use blog.helpers)
  (:require [noir.server :as server]))

(server/load-views "src/blog/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    ; TODO : factor out mongo connectivity so this works when deployed
    (monger-connect! "mongodb://127.0.0.1/blog")
    (server/start port {:mode mode
                        :ns 'blog})))

