

package com.simple

class multipleConstructors(name:String,acc_id:Int,balance:Int) {
  
  def this(a:String,b:Int){
    this(a,b,0)
  }
  def this(b:Int){
    this("",b,0)
  }
  def this(){
    this("",0,0)
  }
  def show(){
    print("\nname: "+name)
    print("\nacc_id: "+acc_id)
    print("\nbalance: "+balance)
  }
}

object cons {
  def main(args:Array[String]){
    var a = new multipleConstructors("sri",123,10000)
    a.show()
    var b = new multipleConstructors("zari",456)
    b.show()
    var c = new multipleConstructors()
    c.show()
  }
}