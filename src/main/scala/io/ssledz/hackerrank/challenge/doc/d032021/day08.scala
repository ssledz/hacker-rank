package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 8: Dictionaries and Maps
  * https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem
  */
object day08 {

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt

    def pair(s: String): (String, String) = {
      val arr = s.split(' ')
      arr(0) -> arr(1)
    }

    val dict = (1 to n).map(_ => pair(lines.next())).toMap

    while (lines.hasNext) {
      val key = lines.next()
      println(dict.get(key).map(key + "=" + _).getOrElse("Not found"))
    }

  }

}
