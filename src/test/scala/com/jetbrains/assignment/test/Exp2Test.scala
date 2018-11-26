package com.jetbrains.assignment.test

import org.scalatest.FunSuite
import com.jetbrains.assignment.Exp2

class Exp2Test extends FunSuite {

  test("The recursive exp2 method is called with a negative Integer") {
    val exception = intercept[IllegalArgumentException] {
      Exp2.calculateExp2Recursive(-2)
    }
    assert(exception.getMessage === "The exponent cannot be negative")

  }

  test("The recursive exp2 method is called with zero") {
    assert(Exp2.calculateExp2Recursive(0) === 1)
  }

  test("The recursive exp2 method is called with 1") {
    assert(Exp2.calculateExp2Recursive(1) === 2)
  }

  test("The recursive exp2 method is called with 2") {
    assert(Exp2.calculateExp2Recursive(2) === 4)
  }

  test("The recursive exp2 method is called with 10") {
    assert(Exp2.calculateExp2Recursive(10) === 1024)
  }

}
