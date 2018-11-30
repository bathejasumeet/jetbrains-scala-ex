package com.jetbrains.assignment.test

import com.jetbrains.assignment.warmup.Exp2
import org.scalatest.FunSuite

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

  test("The recursive exp2 method is called with one") {
    assert(Exp2.calculateExp2Recursive(1) === 2)
  }

  test("The recursive exp2 method is called with two") {
    assert(Exp2.calculateExp2Recursive(2) === 4)
  }

  test("The recursive exp2 method is called with ten") {
    assert(Exp2.calculateExp2Recursive(10) === 1024)
  }

  test("The optimised exp2 method is called with a negative Integer") {
    val exception = intercept[IllegalArgumentException] {
      Exp2.calculateExp2(-2)
    }
    assert(exception.getMessage === "The exponent cannot be negative")
  }

  test("The optimised exp2 method is called with zero") {
    assert(Exp2.calculateExp2(0) === 1)
  }

  test("The optimised exp2 method is called with one") {
    assert(Exp2.calculateExp2(1) === 2)
  }

  test("The optimised exp2 method is called with two") {
    assert(Exp2.calculateExp2(2) === 4)
  }

  test("The optimised exp2 method is called with ten") {
    assert(Exp2.calculateExp2(10) === 1024)
  }

}
