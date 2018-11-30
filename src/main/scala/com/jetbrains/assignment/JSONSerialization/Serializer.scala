package com.jetbrains.assignment.JSONSerialization

/** JSON Serializer for BooelanExpresison
  *
  */
object Serializer {
  def parseToJson(expression: BooleanExpression): String = {

    expression match {
      case _: True.type => "true"
      case _: False.type => "false"
      case Variable(symbol) => s"""{"Symbol":"$symbol"}"""
      case Not(e) => """{"Not":""" + parseToJson(e) +"""}"""
      case _ => throw new IllegalArgumentException("Illegal arguments passed")
    }


  }

}
