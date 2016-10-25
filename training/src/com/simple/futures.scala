package com.simple

import io.StdIn._
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.parallel.ParallelCollectionImplicits
import scala.util.Success
import scala.util.Failure

object futures extends App {
  
  println("Program Execution 1")
  
  val fut = Future {
    println("Printing Future")
  }
  
  Thread.sleep(1000)
  println("Program Execution 2")
  
  val fut2 = Future {
    var l = new ListBuffer[Int]()
    for (i <- 1 to 10) {
      l += i
    }
    val lis = l.toList
  // throw new RuntimeException("This is forceful Exception")
  }
  fut2.onComplete { 
    case Success(n) => println(n)
    case Failure(ex) => println("something went wrong: "+ex)
    }
  
  // Future Object Methods
   
  val page1 = Future {
    "google "+io.Source.fromURL("http://www.google.com").take(100).mkString
  }
  val page2 = Future {
    "yahoo "+io.Source.fromURL("http://www.yahoo.com").take(100).mkString
  }  
  val page3 = Future {
    "sify "+io.Source.fromURL("http://www.sify.com").take(100).mkString
  }  
  
  val pages = List(page1,page2,page3)
 
  // prints the first page which responds 
  val firstpage = Future.firstCompletedOf(pages)
  firstpage.foreach { println }
  
  // Print all the pages 
  val allpages = Future.sequence(pages)
  allpages.foreach { println }
  
  
}