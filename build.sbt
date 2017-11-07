name := """PizzaSystem"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.3",
  "org.jsoup" % "jsoup" % "1.8.1" % "test",
  specs2 % Test
)
