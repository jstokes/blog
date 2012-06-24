(ns blog.views.welcome
  (:require [blog.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.page-helpers :only [html5 include-css include-js]]))


(defpage "/" []
  (html5
    [:head
     [:title "Jeff Stokes"]]
     [:body 
      [:h1 "My Blog" ]]))
      
