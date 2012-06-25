(ns blog.models.mongo
  (:require [monger.collection :as mc])
  (:require [monger.core :as mg])
  (:use monger.operators)
  (:import [org.bson.types ObjectId]))

(defn connect! 
  [] 
  (let [uri (get (System/getenv) "MONGODB_URI" "mongodb://127.0.0.1/blog")]
    (mg/connect-via-uri! uri)))

(defn retrieve 
  [id]
  (mc/find-map-by-id "entry" (ObjectId. id)))

(defn save 
  [map]
  (let [oid (ObjectId.)]
    (mc/insert "entry" (conj {:_id oid} map))
    (str oid)))
