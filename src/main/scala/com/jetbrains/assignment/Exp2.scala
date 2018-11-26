package com.jetbrains.assignment


/** Warm-Up exercise in the assignment - (implementation of exponentiation to power 2) */
object Exp2 {
  //TODO specify that you assumed the datatype to be integer, just in case

  /** Implements the recursive function on pg4 of the assignment, multiplying by 2 for simplification / reducing time
    * complexity
    *
    * @param exponent the exponent to which 2 needs to be raised
    * @return The answer of the exponentiation
    */
  def calculateExp2Recursive(exponent: Int): Int = {
    if (exponent < 0) throw new IllegalArgumentException("The exponent cannot be negative")
    if (exponent == 0) return 1
    calculateExp2Recursive(exponent - 1) + calculateExp2Recursive(exponent - 1)
  }
}
