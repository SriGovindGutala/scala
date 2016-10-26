package com.simple
/* - Functions that take other functions as parameters or that return functions as results are higher order functions.
 * - A function which is having anonymous function as a parameter is called as higher order fucntion
 * 
 */
object higherOrderFunc {
  
  // Higher Order fucntion
  def perform(anony:(Int,Int) => Int){
    println(anony(12,12))
  }
  def apply(f: Int => String, v: Int) = f(v)
  
  def layout[A](x: A) = "[" + x.toString() + "]"
  
  def main(args:Array[String]){
   println("hello") 
   perform((x:Int,y:Int)=>x*y)
   println( apply( layout, 10) )
   
  }
}
