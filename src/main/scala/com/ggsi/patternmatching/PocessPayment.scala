package com.ggsi.patternmatching

trait Payment {
  def pay(amount: Double): Unit
}

class Cash extends Payment {
  def pay(amount: Double): Unit = println(s"Pay with cash $amount")
}
case class CreditCard(fullName: String) extends Payment {
  def pay(amount: Double): Unit = println(s"Pay with credit card $amount")
  def verify(): Unit = println("Verification...")
}

object PocessPayment extends App {

  def processPayment(amount: Double, method: Payment) = method match {
    case cash: Cash => cash.pay(amount)
    case card: CreditCard => {
      card.verify()
      card.pay(amount)
    }
    case _ => println("Unknown payment method")
  }

  val paymentA = new Cash
  val paymentB = new CreditCard("Alex Zvolinskiy")

  processPayment(10, paymentA)
  //Pay with cash 10.0

  processPayment(50, paymentB)
}