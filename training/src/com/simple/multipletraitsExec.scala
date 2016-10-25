package com.simple

object multipletraitsExec {
   def main(args:Array[String])
   {
    val a:three = new three()
    a.fun()
    a.good()
    val b:four = new four()
    b.good()
   }
}
class three extends trait_one with trait_two {
   val name = "Sri"
   def fun()
   {
    println("Printing trait_one fun method")
  }
}
class four extends trait_four with trait_five

