package etikedilo

import sbt._
import sbt.Keys._
import scala._
import com.typesafe.sbt.SbtAtmosPlay.atmosPlaySettings

object BuildSettings {
  val buildVersion = "0.1"
  val buildScalaVersion = "2.10.3"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies ++= (Seq(Dependencies.scalaTest) ++ Dependencies.akka),
    resolvers ++= ImgLib2.resolvers
  )

}

object Resolvers {

}

object Dependencies {
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.2.3"
  val akkaTest = "com.typesafe.akka" %% "akka-testkit" % "2.2.3"
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % "2.2.3"

  val akka = akkaActor :: akkaTest :: akkaSlf4j :: Nil


  val typesafeConsole = "com.typesafe.atmos" % "trace-play-2.2.0" % "1.3.1"
  val typesafeConfig = "com.typesafe" % "config" % "1.0.2"
  val scalaTest = "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
}

object FormikoBuild extends Build {

  import BuildSettings._

  val projectName = "formiko"

  lazy val formiko = Project(
    id = projectName,
    base = file("."),
    settings = buildSettings ++ Seq(name := projectName)
  )
}
