package com.akka

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorSystem

object akkaParentChild extends App{
  case object CreateChilden
  case class SignalToChild(a: Int)
  case class PrintChild(a: Int)
  class ParentActor extends Actor{
    private var childnum = 0
    def receive = {
      case CreateChilden =>
        context.actorOf(Props[ChildActor],"Child"+childnum)
        childnum += 1
      case SignalToChild(n) =>
        context.children.foreach(a => a ! PrintChild(n))
    }
  }
   class ChildActor extends Actor{
    private var childnum = 0
    def receive = {
      case PrintChild(a) =>
        println(a+" "+self)
    }
  }
  
  val system = ActorSystem("HirarchySystem")
  val actor = system.actorOf(Props[ParentActor],"Parent1")
  val actor2 = system.actorOf(Props[ParentActor],"Parent2")
  
  actor ! CreateChilden
  actor ! SignalToChild(1)
  actor ! CreateChilden
  actor ! CreateChilden
  actor ! SignalToChild(2)
  
  actor2 ! CreateChilden
  val child0 = system.actorSelection("akka://HirarchySystem/user/Parent2/Child0")
  child0 ! PrintChild(3)

  
  Thread.sleep(1000)
  system.terminate()
  
}