package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 20: Sorting
  * https://www.hackerrank.com/challenges/30-sorting/problem
  */
object day20 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    val xs    = lines.next().split(' ').map(_.toInt)

    val swaps = sort(xs)
    println(s"Array is sorted in $swaps swaps.")
    println(s"First Element: ${xs.head}")
    println(s"Last Element: ${xs.last}")

  }

  def sort(xs: Array[Int]): Int = {

    def swap(i: Int, j: Int): Unit = {
      val tmp = xs(i)
      xs(i) = xs(j)
      xs(j) = tmp
    }

    var allSwaps = 0

    (0 until xs.size).foreach { i =>
      var swaps = 0
      (0 until xs.size - 1).foreach { j =>
        if (xs(j) > xs(j + 1)) {
          swap(j, j + 1)
          swaps = swaps + 1
        }
      }

      if (swaps == 0) {
        return allSwaps
      }

      allSwaps = allSwaps + swaps
    }

    allSwaps
  }

}
