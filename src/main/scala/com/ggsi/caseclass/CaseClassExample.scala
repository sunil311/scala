package com.ggsi.caseclass

//declare
case class Employee(userName:String,password:String)

object CaseClassExample {
  def main(args: Array[String]) {
    //declare
    val employee = Employee("employee123","password123")

    //access fields
    val employeeUserName = employee.userName

    println("employee user name is "+employeeUserName)

    //create a copy
    val newEmployee = employee.copy(userName = "employee124")

    //compare objects
    assert(employee != newEmployee)
    
  }
}
