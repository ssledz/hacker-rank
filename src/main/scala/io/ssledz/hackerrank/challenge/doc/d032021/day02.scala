package io.ssledz.hackerrank.challenge.doc.d032021

object day02 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()

    val mealCost = lines.next().trim.toDouble

    val tipPercent = lines.next().trim.toInt

    val taxPercent = lines.next().trim.toInt

    println(Math.round(mealCost * (1 + (tipPercent + taxPercent) / 100.0)))

  }

}
