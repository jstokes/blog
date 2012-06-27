(ns blog.models.mongo
  (:require [monger.collection :as mc])
  (:require [monger.core :as mg])
  (:use monger.operators)
  (:import [org.bson.types ObjectId]))

(def COLLECTION "entry")

(defn- idify [id]
  (ObjectId. id))

(defn connect! 
  [] 
  (let [uri (get (System/getenv) "MONGODB_URI" "mongodb://127.0.0.1/blog")]
    (mg/connect-via-uri! uri)))

(defn retrieve 
  [id]
  (mc/find-map-by-id COLLECTION (idify id)))

(defn save 
  [map]
  (let [oid (ObjectId.)]
    (mc/insert COLLECTION (conj {:_id oid} map))
    (str oid)))

(defn delete [id]
  (mc/remove-by-id COLLECTION (idify id)))
