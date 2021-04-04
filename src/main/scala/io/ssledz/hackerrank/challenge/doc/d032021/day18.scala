package io.ssledz.hackerrank.challenge.doc.d032021

/** Day 18: Queues and Stacks
  * https://www.hackerrank.com/challenges/30-queues-stacks/problem
  */
object day18 {

  def main(args: Array[String]): Unit = {

    val lines = io.Source.stdin.getLines()
    val n     = lines.next().toInt

  }

  import collection.mutable

  class Solution(queue: mutable.Queue[Char] = mutable.Queue.empty, stack: mutable.Stack[Char] = mutable.Stack.empty) {
    def pushCharacter(c: Char): Unit    = stack.push(c)
    def enqueueCharacter(c: Char): Unit = queue.enqueue(c)
    def popCharacter(): Char              = stack.pop()
    def dequeueCharacter(): Char          = queue.dequeue()
  }

}
