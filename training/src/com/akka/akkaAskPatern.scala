package com.akka

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.duration._
import akka.actor.ActorRef
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success
import akka.actor.actorRef2Scala

object akkaAskPatern extends App{
  case object AskName
  case class NameResponse(name: String)
  case class AskNameOf(boy: ActorRef)
  
  class AskActor(val name: String) extends Actor{
    implicit val ec = context.system.dispatcher
    def receive = {
      case AskName => 
        sender ! NameResponse(name)
      case AskNameOf(boy) => 
        val f = boy ? AskName
        f.onComplete {
          case Success(NameResponse(s)) => println("It says: "+s)
          case Success(s) => println("Some other name observed"+s)
          case Failure(ex) => println("It didnt respond the name")
        }
        val currentsender = sender
        Future {
          sender ! "Sending the current message"
        }
    }
  }
  val system = ActorSystem("SimpleSystem")
  val actor1 = system.actorOf(Props(new AskActor("Sri")),"AskActor1")
  val actor2 = system.actorOf(Props(new AskActor("Govi")),"AskActor2") 
  
  implicit val ec = system.dispatcher
  implicit val timeout = Timeout(1.seconds)
  
  actor1 ! AskNameOf(actor2)
  val answer = actor1 ? AskName
  answer.foreach(a => println("name = "+a))
  system.terminate()
  
}