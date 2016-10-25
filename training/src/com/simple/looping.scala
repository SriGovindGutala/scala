// while, do-while, for
// for loop has generator. It creates a val variable
// you can use to and until. Until will not use the last value

package com.simple

object looping {
  def main(args:Array[String]){
    
    var i = 0
    
    while(i<5)
    {
      print("i = "+i+"\n")
      i += 1
    }
    print(i)
    
    do{
      print("i = "+i+"\n")
      i -= 1
    }while(i>1)
      
      for(y <- 1 to 10){
        println(y)
      }
    
  }
}