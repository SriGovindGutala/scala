package com.akka

// - Akka is used for parellism in scala
// - Everything that is in Actor needs to define a receive method
// - In order to use Akka we need to have classes for actors and also we need to build a system
// - We cant create actors as an instance ( new keyword)
// - Actor system can't call methods because the methods inner leaves threads. 
//   We can only pass messages and they are pulled from a queue and handled one at a time
// - The ActorRef wraps around the actor and it provides the message box handling 
//   so when the messages are received, that can start up a actor on its thread and have it processed those messages.
// - In Akka the messages are a type of any

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala

object akkaSimpleActor extends App{
  
  class SimpleActor extends Actor{
    def receive = {
      case s:String => println("String : "+s)
      case i:Int => println("Int : "+i)
    }
    
    def foo = println("Sample method")
  }
  // building an actorsystem and a new actor
  val system = ActorSystem("SimpleSystem")
  // val actor = new SimpleActor | you can create an instance for an actor
  // Props is about, how it is going to built it. we pass in the type we need to create
  val actor = system.actorOf(Props[SimpleActor],"SimpleActor")
  // now it waits to send messages 
  // to send messages say actor then bank and then message
 
  println("Before sending messages")
  actor ! "hi there"
  println("After string message")
  actor ! 12
  println("Before int message")
  actor ! 'a'
  println("after some charector")
  
  // actor sends messages and it receives in a separate thread and gets queued up
  // for that reason it doesn't print the messages until other things happen
  system.terminate()
  
}



