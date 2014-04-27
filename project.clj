(defproject cljs38 "0.1.0"
  :description "Can you make every row add up to 38?"
  :url "http://github.com/arthens/cljs38"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [com.cemerick/clojurescript.test "0.3.0"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/clojurescript.test "0.3.0"]]

  :cljsbuild {:builds [{:id "production"
                        :source-paths ["src"]
                        :compiler {:output-to "web/js/compiled/cljs38.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}

                       {:id "testable"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "web/js/compiled/cljs38_test.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]

              :test-commands {"unit-tests" ["phantomjs" :runner
                                            "web/js/compiled/cljs38_test.js"]}})
