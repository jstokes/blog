(ns blog.test.models.mongo
  (:use [lazytest.describe :only (describe do-it)]
        [lazytest.expect :only (expect)])
  (:use blog.models.mongo)
  (:require [monger.core :as mg]))

(connect!)
(mg/set-db! (mg/get-db "unit-test"))

(describe mongo
  (do-it "can save and retrieve documents"
    (let [id (save {:test "true"})]
      (expect (= "true" (get (retrieve id) :test))))))
