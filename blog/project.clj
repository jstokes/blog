(defproject blog "0.1.0-SNAPSHOT"
  :description "Small clojure blog app"
  :plugins [[lein-cljsbuild "0.2.1"]]
  :cljsbuild {
    :builds [{:source-path "src"
              :compiler {
                 :output-to "resources/public/client.js"
                 :optimizations :whitespace
                 :pretty-print true}}]}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [noir "1.2.2"]
                 [fluentsoftware/cljs-binding "1.0.0-SNAPSHOT"]
                 [com.novemberain/monger "1.0.0-beta8"]
                 [fluentsoftware/cljs-binding "1.0.0-SNAPSHOT"]]
  :main blog.server)
