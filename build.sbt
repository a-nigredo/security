name := "security"

version := "0.1"

scalaVersion := "2.12.5"
resolvers += Resolver.bintrayRepo("janstenpickle", "maven")
scalacOptions += "-Ypartial-unification"
scalacOptions += "-feature"
scalacOptions += "-language:higherKinds"

val http4sVersion = "0.18.6"
val doobieVersion = "0.5.2"

libraryDependencies ++= Seq(
  "extruder" %% "extruder" % "0.7.5",
  "extruder" %% "extruder-typesafe" % "0.7.5",
  "extruder" %% "extruder-refined" % "0.7.5",
  "org.typelevel" %% "cats-core" % "1.0.1",
  "org.tpolecat" %% "doobie-core" % doobieVersion,
  "org.tpolecat" %% "doobie-postgres" % doobieVersion,
  "org.tpolecat" %% "doobie-specs2" % doobieVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
  "com.softwaremill.macwire" %% "util" % "2.3.0"
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")
crossPaths := false