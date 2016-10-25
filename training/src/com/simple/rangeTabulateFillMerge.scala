package com.simple

object rangeTabulateFillMerge {
  def main(args:Array[String]){
    val a = List.range(0,10,2)
    val b = List.tabulate(10)(v => v*v)
    val c = List.fill(5)(10)
    val d = List.fill(5)(a)   
    val e = a ::: b ::: c
    
    println("a = "+a)
    println("b = "+b)
    println("c = "+c)
    println("d = "+d)
    println("e = "+e)
    
  }
}