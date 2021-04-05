package io.ssledz.hackerrank.fp

/** Super Digit
  * https://www.hackerrank.com/challenges/super-digit/problem
  */
object ex43 {

  def superDigit(p: Long): Int = {
    def sumOfDig(x: Long, acc: Int): Int =
      if (x == 0) acc
      else sumOfDig(x / 10, acc + (x % 10).toInt)
    if (p / 10 == 0) p.toInt else superDigit(sumOfDig(p, 0))
  }

  def main(args: Array[String]): Unit = {
    val lines         = io.Source.stdin.getLines()
    val n :: k :: Nil = lines.next().split(' ').toList
    val nn = n.toList.foldLeft(0L) { (acc, c) =>
      acc + (c - '0')
    }
    val p = nn * k.toInt
    println(superDigit(p))
  }

}
