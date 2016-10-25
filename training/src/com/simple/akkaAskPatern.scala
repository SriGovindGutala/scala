package com.simple

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object akkaAskPatern extends App{
case object AskName
  case class NameResponse(name: String)
  
  class AskActor(val name: String) extends Actor{
    def receive = {
      case AskName => sender ! NameResponse(name)
    }
  }
  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props(new AskActor("Sri")),"AskActor")
  
  implicit val timeout = Timeout(1.seconds)
  val answer = actor ? AskName
  
  answer.foreach(a => println("name = "+a))
  system.terminate()
  
}