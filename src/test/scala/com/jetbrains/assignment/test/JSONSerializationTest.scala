package com.jetbrains.assignment.test

import com.jetbrains.assignment.JSONSerialization._
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

  test("The Serializer is called with Variable") {
    assert(Serializer.parseToJson(Variable("sample")) === """{"Symbol":"sample"}""")
  }

  test("The Serializer is called with Not for True") {
    assert(Serializer.parseToJson(Not(True)) === """{"Not":true}""")
  }

  test("The Serializer is called with Not for False") {
    assert(Serializer.parseToJson(Not(False)) === """{"Not":false}""")
  }

  test("The Serializer is called with And for Primitive True/False without recursion") {
    assert(Serializer.parseToJson(And(True, False)) === """{"And":{"e1":true,"e2":false}}""")
  }

  test("The Serializer is called with Or for Primitive True/False without recursion") {
    assert(Serializer.parseToJson(Or(True, False)) === """{"Or":{"e1":true,"e2":false}}""")
  }

}
