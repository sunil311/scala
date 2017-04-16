package com.ggsi.implicits

class SimpleUrl(_protocol: String, _url: String, _port: Int) {
  val protocol = _protocol
  val url = _url
  val port = _port
  override def toString = protocol + ":" + url + ":" + port
}

class Configuration {
  var isDevelopment = false
  var numberOfRetries = 10
  var url: SimpleUrl = null

  override def toString = isDevelopment + "," + numberOfRetries + "," + url
}

object ImplicitTest {
  def main(args: Array[String]) {

    implicit def str2int(string: String): Int = Integer.valueOf(string).intValue
    implicit def str2bool(string: String): Boolean = string.toUpperCase.equals("TRUE")
    implicit def str2url(string: String): SimpleUrl = {
      val parts = string.split(":", 3)
      new SimpleUrl(parts(0), parts(1), parts(2))
    }
    val userInput1 = "true"
    val userInput2 = "20"
    val userInput3 = "http://www.google.com:3000"

    var configuration = new Configuration
    configuration.isDevelopment = userInput1
    configuration.numberOfRetries = userInput2
    configuration.url = userInput3

    println(configuration)
  }
}