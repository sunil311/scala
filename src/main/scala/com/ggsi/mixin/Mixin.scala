package com.ggsi.mixin

object Mixin {

  def main(a: Array[String]) = {
    val gQuota = new GeneralQuota
    gQuota.printQuotaDetail
    val tQuota = new TatkalQuota
    tQuota.printQuotaDetail
    println("Is it Special train : " + tQuota.isSpecialTrain)
    val lQuota = new LadiesQuota
    lQuota.printQuotaDetail
    println("Is it Special train : " + lQuota.isSpecialTrain)
    lQuota.printTrainInfo
  }

  // Abstract Class
  abstract class AbsInfo {
    def isSpecialTrain: Boolean
  }

  // Trait Object
  trait MyTrain {
    def printTrainInfo = {
      println("Train Number : 12675")
      println("Train Name : KOVAI EXPRESS")
    }
  }

  // Normal Class
  class GeneralQuota {
    def printQuotaDetail = println("General Quota")
  }

  // Abstract class with interface method implementation 
  class TatkalQuota extends AbsInfo {

    def printQuotaDetail = println("Tatkal Quota")

    def isSpecialTrain: Boolean = false

  }

  // Mixin Class composition
  class LadiesQuota extends AbsInfo with MyTrain {
    def printQuotaDetail = println("Ladies Quota")
    def isSpecialTrain: Boolean = false
  }
}