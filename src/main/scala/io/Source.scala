package io

import scala.collection.Iterator

object Source {

  object stdin {

    def getLines(): Iterator[String] = {
      val main = Thread.currentThread().getStackTrace.toList.last
      val path = main.getClassName.replace('.', '/')
      val uri  = classOf[Source.type].getClassLoader.getResource(s"$path.txt").toURI
      //noinspection SourceNotClosed
      scala.io.Source.fromFile(uri).getLines()
    }

  }

}
