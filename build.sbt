import Dependencies.Library

name := "hacker-rank"

version := "0.1"

scalaVersion := "2.13.5"

addCommandAlias("fmt", ";scalafmt ;test:scalafmt ;scalafmtSbt")

// https://github.com/typelevel/kind-projector
lazy val typeSystemEnhancements = compilerPlugin(Library.kindProjector cross CrossVersion.full)

// https://github.com/oleg-py/better-monadic-for
lazy val betterMonadicFor = compilerPlugin(Library.betterMonadicFor)


libraryDependencies ++= Seq(
  typeSystemEnhancements,
  betterMonadicFor
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "utf-8",
  "-explaintypes",
  "-feature",
  "-language:_",
  "-unchecked",
  "-Ywarn-unused:_",
  "-Ymacro-annotations"
)

def filterScalacFlags(xs: Seq[String]) : Seq[String] = xs.filterNot(_ == "-Xfatal-warnings")

scalacOptions.in(Compile) ~= filterScalacFlags

enablePlugins(ScalafmtPlugin)