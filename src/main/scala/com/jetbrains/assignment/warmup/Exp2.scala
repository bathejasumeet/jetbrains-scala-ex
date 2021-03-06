package com.jetbrains.assignment.warmup

import scala.math.pow

/** Warm-Up exercise in the assignment - (implementation of exponentiation to power 2) */
object Exp2 {

  /** Implements the recursive function on pg4 of the assignment, multiplying by 2 for simplification / reducing time
    * complexity
    *
    * @param exponent the exponent to which 2 needs to be raised
    * @return The answer of the exponentiation
    */
  def calculateExp2Recursive(exponent: Int): Int = {
    if (exponent < 0) throw new IllegalArgumentException("The exponent cannot be negative")
    if (exponent == 0) return 1
    2 * calculateExp2Recursive(exponent - 1)
  }

  /** Implements the efficient version of function on pg4 of the assignment
    *
    * @param exponent the exponent to which 2 needs to be raised
    * @return The answer of the exponentiation
    */
  def calculateExp2(exponent: Int): Int = {
    if (exponent < 0) throw new IllegalArgumentException("The exponent cannot be negative")
    if (exponent == 0) return 1
    pow(2, exponent).toInt
  }
}
