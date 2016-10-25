package com.simple
/*
 * 
 */
import scala.util.control.NonFatal
import scala.util.control.Breaks._
import io.StdIn._

object annonymousFunc {
  def main(args:Array[String]){
    val f=()=>println("Printing Data")
    val add=(x:Int,y:Int)=>println("Adding : "+ (x+y))
    val sub=(x:Int,y:Int)=>println("Subtract : "+ (x-y))
    val mul=(x:Int,y:Int)=>println("multiply = "+(x*y))
    val div=(x:Int,y:Int)=>println("multiply = "+(x/y))
    val calulator=(x:Int,y:Int,oper:String)=>{
     oper match {
       case "+" => add(x,y)
       case "-" => sub(x,y)
       case "*" => mul(x,y)
       case "/" => div(x,y)
     }
      
    }
    f.apply()
    add(2,4)
    sub(2,4)
    mul(3,3)
   while (true){
     try
      {
       var count = 0
       breakable{ val x = readLine("enter x = ").toInt
        val y = readLine("enter y = ").toInt
        val oper = readLine("enter operator = ")
        calulator(x,y,oper)
        count += 1
        if (count == 1)
          println("hello")
          break
       }}
      catch
      { 
        case NonFatal(t) => 
          println("Enter the right parameters")
      }
   }
  }
}