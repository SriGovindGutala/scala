package com.simple

/* Singleton is a single used task.
   You cant create an instance of a singleton object
   Companion Class, Companion Object: They can access the private data members of each other
 
* */
object singletonCompanionObj {
  def main(args:Array[String]){
    var abc:hello = new hello
    abc.show()
    hello.display()
  }
}
object hello {
  private var a:Int = 3
    def display() {
    var c:hello = new hello()
    println("Printing value b: "+c.b)
  }
}

class hello {
  import hello._
  private var b:Int = 10
  def show() {
    println("Printing value a: "+a)
  }
}