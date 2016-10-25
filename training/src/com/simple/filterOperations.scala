package com.simple
/*
 * - Filter takes a function and returns a boolean value. 
 * - It will apply that function on every element of the list
 * 	 and then returns the value the function outputs as true.
 */
object filterOperations {
  
  def main(args:Array[String]){
   val a = List.range(0,20)
   val b = a.filter(even)
   val c = a.filter(temp => temp%2==0)
   val d = a.filter(_%2==0)
   val e = a.filter(_ == 2)
   
   c.foreach{ println }
   d.foreach{ println }
   e.foreach{ println }   
   
  }
  def even(a:Int):Boolean ={
    if (a%2==0)
      return true
    else 
      return false
  }
}
