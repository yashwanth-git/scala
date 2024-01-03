package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{
  // Lazy Evaluation = only valuated when its used
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // Useful in infinite collections

  // Psuedo-Collections: Option, Try
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // General way of handling Null in other langs
  /**if(methodWhichCanReturnNull() == null) {
    // Defensive code against null
  }**/
  // Scala uses Option to handle Null
  // Option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  // Try
  def methodWhichCanThrowException(): String = throw new RuntimeException
  // General way of handling Exception
  /**try{
    methodWhichCanThrowException()
  }
  catch{
    case e: Exception => "defend against this evil exception"
  }**/
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  // Future is a "collection" which contains a value when it is evaluated
  // Future is composable with map, flatMap, and filter
  // Monads - abstract and hard to explain

  // Implicits

  //1: Implicit Arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 49
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // 2: implicit conversions
  implicit class MyRichInteger(n:Int){
    def isEven() = n%2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()
  // Use Implicits with very much care
}
