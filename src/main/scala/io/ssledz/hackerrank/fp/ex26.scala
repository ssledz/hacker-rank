package io.ssledz.hackerrank.fp

/** Mirko at the Construction Site
  * https://www.hackerrank.com/challenges/mirko-at-construction-site/problem?h_r=next-challenge&h_v=zen
  */
object ex26 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    def ints  = lines.next().split(' ').map(_.toInt)
    val nq    = ints
    val q     = nq.tail.head
    val initH = ints
    val v     = ints
    val qs    = (1 to q.toInt).map(_ => lines.next().toInt)

    val xs = initH.zip(v)

    import collection.mutable

    val cache = mutable.SortedMap.empty[Int, Int]

    def query(d: Int): Int = (cache.maxBefore(d), cache.minAfter(d)) match {
      case (Some(_ -> i1), Some(_ -> i2)) if i1 == i2 => i1
      case _ =>
        val (_, (i, _)) = xs.foldLeft((1, (0, 0L))) { case ((i, prev @ (_, max)), (init, v)) =>
          val h = init + d.toLong * v
          (i + 1, if (h >= max) (i, h) else prev)
        }
        cache.update(d, i)
        i
    }

    qs.foreach(d => println(query(d)))

  }

}
