package com.ggsi.caseclass

object Test extends App {
  def moneyTransfer(amount: Double, providerFee: Double => Double): Double = {
    amount + 10 + providerFee(amount)
  }
  println(moneyTransfer(250, m => m / 10))
  
}