ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "StormHelloWorld"
  )
libraryDependencies += "org.apache.storm" % "storm-core" % "1.0.3" % "provided"
