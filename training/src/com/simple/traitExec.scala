package com.simple

object traitExec {
  def main(args:Array[String]){
    val a:one = new one()
    a.show()
  }
}
class one extends allTraits {
  override def show(){
        println(babe+" looks beautiful")
  }
}