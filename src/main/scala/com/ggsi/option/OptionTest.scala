package com.ggsi.option

object OptionTest extends App {
  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }

  toInt("ewre") match {
    case Some(i) => println(i)
    case None    => println("That didn't work.")
  }

}