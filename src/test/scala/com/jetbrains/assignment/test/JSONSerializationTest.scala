package com.jetbrains.assignment.test

import com.jetbrains.assignment.JSONSerialization.{False, Serializer, True}
import org.scalatest.FunSuite
import org.scalatest.FunSuite

class JSONSerializationTest extends FunSuite {

  test("The Serializer is called with null") {
    val exception = intercept[IllegalArgumentException] {
      Serializer.parseToJson(null)
    }
    assert(exception.getMessage === "Illegal arguments passed")
  }

  test("The Serializer is called with True") {
    assert(Serializer.parseToJson(True) === "true")
  }

  test("The Serializer is called with False") {
    assert(Serializer.parseToJson(False) === "false")
  }
}
