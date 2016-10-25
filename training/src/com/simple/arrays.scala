

package com.simple

object arrays {
  def main(args:Array[String]){
    var a:Array[Int] = new Array[Int](5)
    for(i <- 0 to 4)
    {
      a(i) = i
      println(a(i)) 
    }
    
    var mularray = Array.ofDim[Int](3,3)
    
    for(i <- 0 to 2 ;j <- 0 to 2) {
      mularray(i)(j) = i+j
        print(mularray(i)(j))
    }
  }
}