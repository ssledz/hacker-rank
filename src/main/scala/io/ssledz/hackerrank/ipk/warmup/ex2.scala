package io.ssledz.hackerrank.ipk.warmup

/** Counting Valleys
  * https://www.hackerrank.com/challenges/counting-valleys/problem
  */
object ex2 {

  def countingValleys(path: String): Int = {
    val (acc, _) = path.foldLeft((0, 0)) {
      case ((acc, h), 'D') if h == 0 => (acc + 1, h - 1)
      case ((acc, h), 'D')           => (acc, h - 1)
      case ((acc, h), 'U')           => (acc, h + 1)
    }
    acc
  }

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    println(countingValleys(lines.next()))
  }

}
