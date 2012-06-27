(ns blog.test.models.mongo
  (:use [lazytest.describe :only (describe do-it)]
        [lazytest.expect :only (expect)])
  (:require [blog.models.mongo :as db])
  (:require [monger.core :as mg]))

(db/connect!)
(mg/set-db! (mg/get-db "unit-test"))

(defn- do-save [doc]
  (db/save doc))

(defn- do-read [id]
  (db/retrieve id))

(defn- do-delete [id]
  (db/delete id))

(describe mongo
  (do-it "can save, retrieve, and delete documents"
    (let [id (do-save {:test "true"})]
      (expect (= "true" (get (db/retrieve id) :test)))
      (do-delete id)
      (expect (= nil (db/retrieve id))))))
