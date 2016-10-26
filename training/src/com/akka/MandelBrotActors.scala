package com.akka

import scalafx.application.Platform
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.image.PixelWriter
import scalafx.scene.paint.Color
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Stops, LinearGradient}
import scalafx.scene.text.Text
import scalafx.scene.image.WritableImage
import scalafx.scene.image.ImageView
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.BalancingPool

object MandelBrotActors extends JFXApp{
  val maxcount = 10000
  val Imagesize = 600
  val XMin = -1.5
  val XMax = 0.5
  val YMin = -1.0
  val YMax = 1.0
  
  case class Complex(real:Double, imag:Double) {
    def +(that: Complex) = Complex(real + that.real, imag + that.imag)
    def *(that: Complex) = Complex(real * that.real - imag * that.imag, real * that.imag + imag * that.real)
    def mag = math.sqrt(real * real + imag * imag)
  }
  
  def mandelCount(c: Complex): Int = {
    var cnt = 0
    var z = Complex(0,0)
    while (cnt < maxcount && z.mag < 4) {
      z = z * z + c
      cnt += 1
    }
    cnt
  }
 
  case class Line(row:Int, y:Double)
  class LineActor(pw: PixelWriter) extends Actor{

    def receive = {
      case Line(row, y) => 
        for(j <- 0 until Imagesize){
          val x = XMin + j*(XMax-XMin)/Imagesize
          Platform.runLater {
          val cnt = mandelCount(Complex(x,y))
          pw.setColor(j,row,if(cnt==maxcount) Color.Black else {
            val scale = 10*math.sqrt(cnt.toDouble/maxcount) min 1.0
            color(scale, 0, 0, 1)})
           }
          }
    }
  }
  
  val system = ActorSystem("MandelSystem")
  
  stage = new JFXApp.PrimaryStage {
    title = "Actor MandelBrot"
    scene = new Scene(Imagesize, Imagesize) {
      val image = new WritableImage(Imagesize, Imagesize)
      content = new ImageView(image)
      val router = system.actorOf(BalancingPool(100).props(Props(new LineActor(image.pixelWriter))),"Pool")
    for (i <- 0 to Imagesize){
      val y = YMin + i*(YMax - YMin)/Imagesize
      router ! Line(1,y)
    }
    }
  }
  
}