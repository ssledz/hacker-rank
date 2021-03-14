package io.ssledz.hackerrank.fp

object ex23 extends App {

  val lines = io.Source.stdin.getLines()

  def readLine() = lines.next()

  val t = readLine().toInt

  (1 to t).foreach { _ =>
    val n     = readLine().toInt
    val xs    = (1 to n).map(_ => readLine().split(' ').toList).map { case a :: b :: Nil => a.toInt -> b.toInt }.toList
    val isFun = xs.groupBy(_._1).forall { case (_, values) => values.map(_._2).distinct.size == 1 }
    if (isFun) println("YES") else println("NO")
  }

}
