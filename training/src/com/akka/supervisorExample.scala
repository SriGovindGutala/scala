package com.akka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.SupervisorStrategy._
import akka.actor.OneForOneStrategy
import akka.actor.Props
import akka.actor.actorRef2Scala

object supervisorExample extends App{
  
  case object CreateChildren
  case class SignalToChild(a: Int)
  case class PrintChild(a: Int)
  case class DevideNum(a:Int, b:Int)
  case object SomethingBad
  
  class ParentActor extends Actor{
    private var childnum = 0
    def receive = {
      case CreateChildren =>
        context.actorOf(Props[ChildActor],"Child"+childnum)
        childnum += 1
      case SignalToChild(n) =>
        context.children.foreach(a => a ! PrintChild(n))
    }
    override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
      case ae:ArithmeticException => { 
        println("ArithmeticException Happened") 
        Resume }
      case _:Exception => 
        println("Actor being shutdown and new actor will be restarted")
        Restart
    }
  }
   class ChildActor extends Actor{
    private var childnum = 0
    def receive = {
      case PrintChild(a) =>
        println(a+" "+self)
      case DevideNum(a,b) =>
        println("result: "+a/b)
      case SomethingBad =>
        throw new RuntimeException("RunTimeException occured")
    }
  }
  
  val system = ActorSystem("SupervisorSystem")
  val actor = system.actorOf(Props[ParentActor],"Parent1")
  val actor2 = system.actorOf(Props[ParentActor],"Parent2")
  
  actor ! CreateChildren
  val child0 = system.actorSelection("akka://SupervisorSystem/user/Parent1/Child0")
  child0 ! DevideNum(4,0)
  child0 ! SomethingBad
  
}