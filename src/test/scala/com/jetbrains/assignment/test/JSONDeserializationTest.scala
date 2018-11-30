package com.jetbrains.assignment.test

import com.jetbrains.assignment.JSONSerialization._
import org.scalatest.FunSuite

class JSONDeserializationTest extends FunSuite {

  test("The Serializer is called with null") {
    val exception = intercept[IllegalArgumentException] {
      Deserializer.parseToBooleanExpression(null)
    }
    assert(exception.getMessage === "Illegal arguments passed for deserialization")
  }

  test("Invalid JSON passed") {
    intercept[Exception] {
      Deserializer.parseToBooleanExpression("""{"a"}""")
    }
  }

  test("Check if boolean true is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""true""") === True)
  }

  test("Check if boolean false is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""false""") === False)
  }

  test("Check if boolean Symbol is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"Symbol":"sample"}""") === Variable("sample"))
  }

  test("Check if Symbol is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""false""") === False)
  }

  test("Check if non recursive not is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"Not":false}""") === Not(False))
  }

  test("Check if  not  with symbol is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"Not":{"Symbol":"abc"}}""") === Not(Variable("abc")))
  }

  test("Check if non recursive and is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"And":{"e1":true,"e2":false}}""") === And(True, False))
  }

  test("Check if non recursive or is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"Or":{"e1":true,"e2":false}}""") === Or(True, False))
  }

  test("Check if recursive complex boolean expression is parsed correctly") {
    assert(Deserializer.parseToBooleanExpression("""{"Or":{"e1":true,"e2":{ "And":{"e1":{"Not":{"And": { "e1":true,"e2":false } }},"e2":{"Or":{"e1":{"Symbol":"123"},"e2":false}}}}}}""") === Or(True, And(Not(And(True, False)), Or(Variable("123"), False)))
    )
  }
}
