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
      case And(e1, e2) => """{"And":{"e1":""" + parseToJson(e1) + ""","e2":""" + parseToJson(e2) + """}}"""
      case Or(e1, e2) => """{"Or":{"e1":""" + parseToJson(e1) + ""","e2":""" + parseToJson(e2) + """}}"""
      case _ => throw new IllegalArgumentException("Illegal arguments passed")
    }
  }

}
