package com.simple

object listCollection {
  
  def main(args:Array[String]){
    // Lists 
    val a = List(12,23,34,45)
    val b = 1 :: a
    val c = 1 :: Nil
    
    // Sets
    val x = Set(1,4,1,4,2,6,"Sri")
    
      println(a)
      println(x)
      println()
      
      x.foreach {println(_)}
      a.foreach { println(_) }
        println("-------")
      a.foreach { println}
        println("-------")
      for (i <- a){ println(i) }
    
  }
}