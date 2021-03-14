package io

import scala.collection.Iterator

object StdIn {

  def readLine(): String = getLines().toList.head

  def getLines(): Iterator[String] = {
    val main = Thread.currentThread().getStackTrace.toList.last
    val path = main.getClassName.replace('.', '/')
    val uri  = getClass.getClassLoader.getResource(s"$path.txt").toURI
    //noinspection SourceNotClosed
    scala.io.Source.fromFile(uri).getLines()
  }

}
