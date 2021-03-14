package io.ssledz.hackerrank

package object fp {
  implicit class DoubleOpts(val arg: Double) extends AnyVal {
    def ~=(value: Double): Boolean = Math.abs(value - arg) <= 0.1
  }
}
