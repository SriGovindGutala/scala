package com.akka

import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorSystem
import scala.concurrent.duration._

object akkaSchedulerExample extends App{

  case class Count(n:String)
  
  class SchedulerActor extends Actor{
    private var num = 0
    def receive = {
      case Count(name) =>
        num += 1
        println("from: "+name+" num: "+num)
    }
  }
  val system = ActorSystem("ActorSchedulerSystem")
  val actor = system.actorOf(Props[SchedulerActor],"Actor1")
  implicit val ec = system.dispatcher
  
  actor ! Count("a")
  
  system.scheduler.scheduleOnce(1.second)(actor ! Count("b"))
  val can = system.scheduler.schedule(0.second, 1000.millis,actor, Count("c"))
  
  Thread.sleep(3000)
  can.cancel()
  system.terminate()
}