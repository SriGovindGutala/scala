package com.simple

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props

object akkaActorCountDown extends App{
  
  case class StartCounting(a:Int, callActor:ActorRef)
  case class CountDown(a:Int)
  
  class countDownActor extends Actor{
    
    def receive = {
      case StartCounting(x,y) => 
        println("he: "+x)
        println(self)
        y ! CountDown(x-1)
      case CountDown(s) =>
        println(self)
        if(s>0)
        {
          println("she: "+s)
          sender ! CountDown(s-1)
        }else{
          context.system.terminate()
        }
    }
  }
  
  val system = ActorSystem("CountDownSystem")
  val actor1 = system.actorOf(Props[countDownActor],"CountDownActor1")
  val actor2 = system.actorOf(Props[countDownActor],"CountDownActor2")
  actor1 ! StartCounting(10, actor2)

}