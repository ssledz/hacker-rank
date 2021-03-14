import sbt._

object Dependencies {

  object Version {
    val betterMonadicFor = "0.3.1"
    val kindProjector    = "0.11.3"
  }

  object Library {

    // Compiler plugins
    val betterMonadicFor = "com.olegpy"   %% "better-monadic-for" % Version.betterMonadicFor
    val kindProjector    = "org.typelevel" % "kind-projector"     % Version.kindProjector

  }

}
