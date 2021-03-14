package io.ssledz.hackerrank.fp

/** Area Under Curves and Volume of Revolving a Curve
  * https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv/problem
  */
object ex13 extends App {

  val lines = io.Source.stdin.getLines()

  def readLine() = lines.next()

  def f(coefficients: List[Int], powers: List[Int], x: Double): Double =
    coefficients.zip(powers).map { case (coeff, pow) => coeff * Math.pow(x, pow) }.sum

  def area(coefficients: List[Int], powers: List[Int], x: Double): Double =
    Math.pow(f(coefficients, powers, x), 2) * Math.PI

  def summation(
      func: (List[Int], List[Int], Double) => Double,
      upperLimit: Int,
      lowerLimit: Int,
      coefficients: List[Int],
      powers: List[Int]
  ): Double =
    Range.BigDecimal
      .inclusive(lowerLimit, upperLimit, 0.001)
      .toList
      .map(x => func(coefficients, powers, x.toDouble) * 0.001)
      .sum

  def nexList                         = readLine().split(' ').map(_.toInt).toList
  val coefficients: List[Int]         = nexList
  val powers: List[Int]               = nexList
  val lowerLimit :: upperLimit :: Nil = nexList

  assert(summation(f, upperLimit, lowerLimit, coefficients, powers) ~= 2435300.3)
  assert(summation(area, upperLimit, lowerLimit, coefficients, powers) ~= 26172951168940.8)

}
