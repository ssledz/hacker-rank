package io.ssledz.hackerrank.ipk.warmup

/** Jumping on the Clouds
  * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
  */
object ex3 {

  def jumpingOnClouds(c: Array[Int]): Int = {
    def go(xs: List[Int], acc: Int): Int =
      xs match {
        case 0 :: 0 :: 0 :: t => go(0 :: t, acc + 1)
        case 0 :: 1 :: t      => go(t, acc + 1)
        case 0 :: Nil         => acc
        case 0 :: t           => go(t, acc + 1)
      }
    go(c.toList, 0)
  }

  def main(args: Array[String]): Unit = {
    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt
    val c     = lines.next().split(' ').map(_.toInt)

    println(jumpingOnClouds(c))
  }

}
