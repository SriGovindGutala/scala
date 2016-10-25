package com.simple

/*
 * -Traits are same as interfaces in java. 
 * -In interface we can declare method and we can define those method in a class which implements those interface
 * -If a class extending a trait, that class has to define all the functions defined in the trait
 * -If the class is not defining all of them then it becomes a abstract class. Abstract class is a class whose object can't be created.
 * -In trait we can declare a function and define a function as well
 * -A varible without initialization is called as abstract field and with initialization are called as concrete fields
 */

trait allTraits {
  val babe = "Katrina"
  def show() {
    println(babe+" looks beautiful")
  }
}
trait trait_one {
  val name:String
  val b:Int = 10
  def fun()
}
trait trait_two {
  def good(){
    println("Printing trait_two good method")
  }
}
trait trait_three {
  def good(){
    println("Printing trait_three good method")
  }
}
trait trait_four extends trait_three{
  override def good(){
    println("Printing trait_four good method")
  }
}
trait trait_five extends trait_three{
  override def good(){
    println("Printing trait_five good method")
  }
}
