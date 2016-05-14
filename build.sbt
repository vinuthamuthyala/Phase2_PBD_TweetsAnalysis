name := "Phase2_PBD_TweetsAnalysis"

version := "1.0"

scalaVersion := "2.11.8"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.1" ,
  "org.apache.spark" %% "spark-streaming" % "1.4.1",
  "org.apache.hadoop" % "hadoop-common" % "2.7.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
  "org.apache.spark" %% "spark-mllib" % "1.4.1" )