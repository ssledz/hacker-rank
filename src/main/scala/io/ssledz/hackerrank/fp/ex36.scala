package io.ssledz.hackerrank.fp

/** Crosswords-101
  * https://www.hackerrank.com/challenges/crosswords-101/problem
  */
object ex36 {

  type Point = (Int, Int)

  case class Place(ps: List[Point]) {
    def size: Int = ps.size
  }

  def main(args: Array[String]): Unit = {

    val n     = 10
    val lines = io.Source.stdin.getLines()

    val grid = (0 until 10).flatMap { y =>
      lines.next().toList.zipWithIndex.map { case (c, x) => ((x, y), c) }
    }.toMap

    val words = lines.next().split(';').toList.groupBy(_.length)

    def show(grid: Map[Point, Char]): String =
      (0 until n)
        .map { y =>
          (0 until n).map(x => grid((x, y))).mkString
        }
        .mkString("\n")

    def places(min: Int, grid: Map[Point, Char]): List[Place] = {

      def swap(p: Point): Point = p._2 -> p._1

      def points(f: Point => Point): List[List[Point]] =
        (0 until n).map(x => (0 until n).map(y => f((x, y))).toList).toList

      def scan(xs: List[Point]): List[Place] = {
        xs.foldLeft((List.empty[Place], '+')) {
          case ((acc, '+'), p) if grid(p) == '-' => (Place(List(p)) :: acc, '-')
          case ((acc, '-'), p) if grid(p) == '-' => (Place(p :: acc.head.ps) :: acc.tail, '-')
          case ((acc, '-'), p) if grid(p) == '+' => (acc, '+')
          case ((acc, '+'), _)                   => (acc, '+')
        }._1
          .flatMap {
            case place if place.ps.size >= min => List(Place(place.ps.reverse))
            case _                             => List.empty
          }
      }
      (points(identity) ::: points(swap)).flatMap(scan)
    }

    def solve(words: Map[Int, List[String]], ps: List[Place]): List[(Place, String)] = {

      def valid(sol: List[(Place, String)]): Boolean = {
        sol
          .flatMap { case (s, str) =>
            s.ps.zip(str)
          }
          .groupBy(_._1)
          .values
          .map(_.map(_._2).toSet.size)
          .forall(_ == 1)
      }

      def go(ps: List[Place], words: Map[Int, List[String]], acc: List[(Place, String)]): List[List[(Place, String)]] =
        ps match {
          case p :: t =>
            val ws = words(p.size)
            ws.flatMap { w =>
              go(t, words.updated(p.size, ws diff List(w)), (p, w) :: acc)
            }
          case Nil => List(acc)
        }

      val xs = go(ps, words, List.empty)
      xs.filter(valid).head
    }

    val ps = places(words.keys.min, grid)

    val sol = solve(words, ps).flatMap { case (p, s) =>
      p.ps.zip(s)
    }.toMap

    println(show(grid ++ sol))

  }

}
