package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 4: Class vs. Instance
  * https://www.hackerrank.com/challenges/30-class-vs-instance/problem
  */
object day04 {

  def main(args: Array[String]): Unit = {
    val lines    = io.Source.stdin.getLines()
    def int: Int = lines.next().toInt
    val t        = int
    (1 to t).foreach { _ =>
      val age = int
      val p   = new Person(age)
      p.amIOld()
      (1 to 3).foreach { _ =>
        p.yearPasses()
      }
      p.amIOld()
      println()
    }
  }

  class Person(initialAge: Int) {
    var age: Int = if(initialAge < 0) {
      println("Age is not valid, setting age to 0.")
      0
    } else initialAge

    def yearPasses(): Unit = {
      age = age + 1
    }

    def amIOld(): Unit = {
      if (age < 13) println("You are young.")
      else if (age < 18) println("You are a teenager.")
      else println("You are old.")
    }
  }

}
