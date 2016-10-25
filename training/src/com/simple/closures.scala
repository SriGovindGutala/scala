package com.simple
/*
 * - A closure is actually a value whose return value depends on some variable 
 *   which are declared outside the function.
 *      in other terms
 * - A closure is a anonymous function in which we make use of a variable which 
 *   are declared outside of that function
 */

object closures {
  def main(args:Array[String]){
    
    var s:Int = 100
    val closuree = (x:Int) => x * 2
    println(closuree(30))
    
  }
}