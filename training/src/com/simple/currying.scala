package com.simple
/*
 * - If a function takes multiple parameters, it converts that into a firm will take only single parameter
 * - 
 */

object currying {
  def add(a:Int) = {(b:Int) => a+b}
  def sub(a:Int) = (b:Int) => a-b
  def calc(oper:String)(a:Int,b:Int) = {
    oper match {
      case "+" => a+b
      case "-" => a-b
      case "*" => a*b
      case "/" => a/b
      case _ =>  "Enter the right parameters"
    }
  }
  def mapReduce(f:Int => Int,combine:(Int,Int) => Int, Zero:Int)(a:Int,b:Int):Int ={
    if (a >b) Zero
    else combine(f(a),mapReduce(f, combine, Zero)(a+1,b))
  }
  def main(args:Array[String])
  {
    println("res = " + add(10)(10) )
    println("res = " + calc("+")(1,1))
  }
}