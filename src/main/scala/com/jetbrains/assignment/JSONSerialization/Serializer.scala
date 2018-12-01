package com.jetbrains.assignment.JSONSerialization

import org.json4s._
import org.json4s.jackson.JsonMethods._


/** JSON Serializer for BooleanExpression
  *
  * Converts a BooleanExpression Class to appropriate JSON string
  */
object Serializer {

  /** Parses BooleanExpression to JSON
    *
    * @param expression a BooleanExpression instance
    * @return A JSON string
    */
  def parseToJson(expression: BooleanExpression): String = {
    expression match {
      case _: True.type => "true"
      case _: False.type => "false"
      case Variable(symbol) => s"""{"Symbol":"$symbol"}"""
      case Not(e) => """{"Not":""" + parseToJson(e) +"""}"""
      case And(e1, e2) => """{"And":{"e1":""" + parseToJson(e1) + ""","e2":""" + parseToJson(e2) + """}}"""
      case Or(e1, e2) => """{"Or":{"e1":""" + parseToJson(e1) + ""","e2":""" + parseToJson(e2) + """}}"""
      case _ => throw new IllegalArgumentException("Illegal arguments passed for serialization")
    }

  }

  /** A utility function that takes a json string and pretty prints it
    *
    * @param json A json string
    * @return pretty printed json
    */
  def prettyPrintJSON(json: String): String = {
    pretty(render(parse(json)))
  }
}
