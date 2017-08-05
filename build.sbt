import sbt.Keys._

name := "uuid"

organization := "jan.cajthaml"

version := {
  val versionFile = scala.io.Source.fromFile("VERSION")
  try {
    versionFile.mkString.trim
  } finally {
    versionFile.close()
  }
}

description := "fast uuid generator"

scalaVersion in Global := "2.12.2"
crossScalaVersions in Global := Seq("2.11.8", scalaVersion.value)
dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value

scalacOptions in Compile := Seq(
  "-encoding",
  "utf-8",
  "-explaintypes",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-language:postfixOps",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Xcheckinit",
  "-Xlint",
  "-Xlint:inaccessible",
  "-Xlint:nullary-override",
  "-Xlint:nullary-unit",
  "-Xlint:option-implicit",
  "-Xlint:package-object-classes",
  "-Xlint:poly-implicit-overload",
  "-Xlint:private-shadow",
  "-Xlint:unsound-match",
  "-Xlint:missing-interpolator",
  "-Xfuture",
  "-Yrangepos",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-inaccessible",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Ywarn-unused"
)

scalacOptions in (Compile, console) ~= (_.filterNot(
  Set(
    "-Ywarn-unused:imports"
  )))

scalacOptions in Test := Seq(
  "-Ywarn-unused-import",
  "-Ywarn-unused"
)

lazy val test = Project(
  "test",
  file("."),
  settings = Defaults.coreDefaultSettings ++ Seq(
    publishArtifact := false,
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases",
      "Artima Maven Repository" at "http://repo.artima.com/releases"
    ),
    libraryDependencies ++= Seq(
      "com.storm-enroute" %% "scalameter" % "0.8.2" % "test",
      "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    ),
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    parallelExecution in Test := false,
    logBuffered := false
  )
)

