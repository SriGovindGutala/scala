package com.simple

object paternMatching {
  
  def find(x:Any):Any = x match{
    case 1 => 1
    case "Sri" => "Hi Sri"
    case 1.2 => "It's 1.2"
  }
  def main(args:Array[String]){
    println("hello")
    println(find("Sri"))
  }
}