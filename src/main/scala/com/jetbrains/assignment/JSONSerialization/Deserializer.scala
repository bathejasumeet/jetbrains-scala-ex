package com.jetbrains.assignment.JSONSerialization

import org.json4s.JsonAST.{JBool, JObject}
import org.json4s.jackson.JsonMethods.parse

/** JSON Deserializer for BooleanExpression
  *
  * Converts a JSON string to appropriate BooleanExpression Class
  */
object Deserializer {

  implicit val formats = org.json4s.DefaultFormats

  /** Parses JSON to BooleanExpression
    *
    * @param json a json string
    * @return A Boolean Expression equivalent
    */
  def parseToBooleanExpression(json: String): BooleanExpression = {

    if (null == json) throw new IllegalArgumentException("Illegal arguments passed for deserialization")
    val parsedJSON = parse(json)
    parsedJSON match {
      case JBool(value) => if (value) True else False
      case _: JObject => parseMap(parsedJSON.extract[Map[String, Any]])

    }

  }

  /** Parse JSON Object to Boolean Expression
    *
    * @param map of key value pairs in JSON
    * @return A Boolean Expression Equivalent
    */
  def parseMap(map: Map[String, Any]): BooleanExpression = {

    val (key, value) = map.head

    key match {
      case "And" =>
        var (first, second) = getBinaryOperatorArguments(value)
        first = if (checkIfInstanceOfMapStringAny(first)) parseMap(first.asInstanceOf[Map[String, Any]]) else first
        second = if (checkIfInstanceOfMapStringAny(second)) parseMap(second.asInstanceOf[Map[String, Any]]) else second
        And(getOperand(first), getOperand(second))

      case "Or" =>
        var (first, second) = getBinaryOperatorArguments(value)
        first = if (checkIfInstanceOfMapStringAny(first)) parseMap(first.asInstanceOf[Map[String, Any]]) else first
        second = if (checkIfInstanceOfMapStringAny(second)) parseMap(second.asInstanceOf[Map[String, Any]]) else second
        Or(getOperand(first), getOperand(second))

      case "Not" =>
        val first = if (value.isInstanceOf[Map[String, Any]]) parseMap(value.asInstanceOf[map.type]) else value
        print("first is")
        print(first)
        Not(getOperand(first))

      case "Symbol" => value match {
        case s: String => Variable(s)
        case _ => throw new IllegalArgumentException("Variable can only be String!");
      }
    }

  }

  /** Get the binary operator arguments
    *
    * @param value A value of KVP of a binary operator , for eg: And
    * @return arguments as a tuple
    */
  def getBinaryOperatorArguments(value: Any): (Any, Any) = {
    value match {
      case mapArgs: Map[String, Any] =>
        val listArgs = mapArgs.toList
        if (2 == listArgs.length) {
          val (_, first) = listArgs.head
          val (_, second) = listArgs(1)
          return (first, second)
        }
    }
    throw new IllegalArgumentException("wrong arguments to binary operator")
  }

  /** Get the 'JSON' operand in terms of BooleanExpression
    *
    * @param operand a JSON operand
    * @return equivalent BooleaExpression operand
    */
  def getOperand(operand: Any): BooleanExpression = {
    operand match {
      case true => True
      case false => False
      case _ => operand.asInstanceOf[BooleanExpression]
    }
  }

  /** Check if an instance of Map[String,Any]
    *
    * @param ele variable to be checked
    * @return true/false
    */
  def checkIfInstanceOfMapStringAny(ele: Any): Boolean = ele.isInstanceOf[Map[String, Any]]

  /** Get the unary operator argument
    *
    * @param value A map containing the unary operator argument
    * @return unary operator argument
    */
  def getUnaryOperatorArguments(value: Any): Any = {
    value match {
      case argsMap: Map[String, Any] =>
        val unaryOpArgs = argsMap.toList
        if (1 == unaryOpArgs.length) {
          val first = unaryOpArgs.head
          return first
        }
    }
    throw new IllegalArgumentException("wrong arguments to unary operator")
  }


}
