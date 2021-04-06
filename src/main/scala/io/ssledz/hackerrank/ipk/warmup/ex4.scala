package io.ssledz.hackerrank.ipk.warmup

/** Repeated String
  * https://www.hackerrank.com/challenges/repeated-string/problem
  */
object ex4 {

  def repeatedString(s: String, n: Long): Long = {
    val len = s.length
    val na = s.foldLeft(0) {
      case (acc, 'a') => acc + 1
      case (acc, _)   => acc
    }
    def go(i: Int, cnt: Int, acc: Long): Long =
      if (cnt == 0) acc
      else go(i + 1, cnt - 1, if (s.charAt(i) == 'a') acc + 1 else acc)
    go(0, (n % len).toInt, n / len * na)
  }

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val s     = lines.next()
    val n     = lines.next().toLong
    println(repeatedString(s, n))
  }

}
