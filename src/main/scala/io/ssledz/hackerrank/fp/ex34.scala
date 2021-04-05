package io.ssledz.hackerrank.fp

import java.nio.file.{Files, Paths}
import scala.sys.process._

/** Convex Hull
  * https://www.hackerrank.com/challenges/convex-hull-fp/problem
  */
object ex34 {

  type Point  = (Int, Int)
  type Vector = (Double, Double)

  implicit class PointOps(val p: Point) extends AnyVal {
    def toVector: Vector = p match {
      case (x, y) => (x.toDouble, y.toDouble)
    }
  }

  implicit class VectorOps(val u: Vector) extends AnyVal {
    def -(v: Vector): Vector = (u, v) match {
      case ((ux, uy), (vx, vy)) => (ux - vx, uy - vy)
    }

    def len: Double = u match {
      case (ux, uy) => Math.sqrt(ux * ux + uy * uy)
    }

    def /(d: Double): Vector = u match {
      case (ux, uy) => (ux / d, uy / d)
    }

    def unit: Vector = u / u.len

    def *(d: Double): Vector = u match {
      case (ux, uy) => (ux * d, uy * d)
    }

    def *(v: Vector): Double = (u, v) match {
      case ((ux, uy), (vx, vy)) => ux * vx + uy * vy
    }
  }

  // https://en.wikipedia.org/wiki/Quickhull
  def quickHull(xs: Set[Point]): List[Point] = {

    def partition(a: Point, b: Point, xs: Set[Point]): (Set[Point], Set[Point]) = {
      val ab       = b.toVector - a.toVector
      val (nx, ny) = ab.unit
      val (ax, ay) = a
      xs.foldLeft((Set.empty[Point], Set.empty[Point])) { case ((l, r), p @ (px, py)) =>
        val dx = px - ax
        val t  = dx / nx
        val y  = ay + t * ny
        if (y < py) (l + p, r) else (l, r + p)
      }
    }

    // https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
    def distance(a: Point, n: Vector, p: Point): Double = {
      val ap = a.toVector - p.toVector
      (ap - (n * (ap * n))).len
    }

    def findHull(xs: Set[Point], p: Point, q: Point): List[Point] = {
      if (xs.isEmpty) List.empty[Point]
      else {
        val pq = q.toVector - p.toVector
        val n  = pq.unit
        val (c, _) = xs.foldLeft((p, 0d)) { case ((pmax, dmax), x) =>
          val d = distance(p, n, x)
          if (d > dmax) (x, d) else (pmax, dmax)
        }
        val (s1, _) = partition(p, c, xs - c)
        val (s2, _) = partition(c, q, xs - c)
        findHull(s1, p, c) ::: List(c) ::: findHull(s2, c, q)
      }
    }

    val (a, b) = xs.foldLeft(((Int.MaxValue, 0), (Int.MinValue, 0))) {
      case ((min @ (xmin, ymin), max @ (xmax, ymax)), p @ (x, y)) =>
        (if (x < xmin || x == xmin && y < ymin) p else min, if (x > xmax || x == xmax && y > ymax) p else max)
    }

    val (s1, s2) = partition(a, b, xs -- Set(a, b))

    a :: findHull(s1, a, b) ::: List(b) ::: findHull(s2, b, a)
  }

  def perimeter(xs: List[Point]): Double =
    (xs.tail ::: List(xs.head))
      .foldLeft((xs.head, 0d)) { case (((x1, y1), acc), x @ (x2, y2)) =>
        (x, acc + Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)))
      }
      ._2

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt

    val points: List[Point] = (1 to n).toList.map { _ =>
      val arr = lines.next().split(' ').map(_.toInt)
      arr(0) -> arr(1)
    }

    val hull = quickHull(points.toSet)
    println(perimeter(hull))
    draw(points, hull)

  }

  def draw(xs: List[Point], hull: List[Point]): Unit = {
    def toStr(xs: List[Point]): String = xs.map { case (x, y) => s"$x $y" }.mkString("\n")

    val dir = Files.createTempDirectory("ex34-")
    val pf  = dir.resolve(Paths.get("ex34.txt"))
    val hf  = dir.resolve(Paths.get("hull.txt"))
    Files.writeString(hf, toStr(hull))
    Files.writeString(pf, toStr(xs))
    Seq(
      "gnuplot",
      "-p",
      "-e",
      s"""plot "$pf" using 1:2 title "points" with points, "$hf" using 1:2 title "hull" with lines"""
    ).!
    Files.delete(pf)
    Files.delete(hf)
    Files.delete(dir)

  }

}
