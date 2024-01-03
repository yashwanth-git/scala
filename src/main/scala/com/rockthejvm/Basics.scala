package com.rockthejvm

// extends App helps to run it standalone
object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42 // const meaningOfLife = 42

  // Int, Boolean, Char, Double, Float - types will be first letter capitalized
  val aBoolean = false // type is optional

  //Strings and String Operations
  val aString = "I don't know Scala!"
  val aComposedString = "I" + " " +"don't"+ " " + "know" + " " + "Scala!" // Concatenate
  val anInterpolatedString = s"The meaning of Life is $meaningOfLife" // String Interpolation

  // Expressions = Structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression =
      if(meaningOfLife > 43) 56
      else if(meaningOfLife < 0) -2
      else if(meaningOfLife > 999) 70
      else 0

  // Code Blocks
  val codeBlock = {
    // Definitions
    val aLocalValue = 67
    // The Value of block is the value of the last expression
    aLocalValue + 3
  }

  // Function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // Recursive Function
  def factorial(n: Int): Int = {
    if(n<=1) 1
    else n * factorial(n - 1)
  }

  // In Scala, don't use loops or iteration, use RECURSION!!!

  // Unit Type = no meaningful value === "void"
  println("I don't know Scala!") // console.log() - no return type [returns void]

  def myUnitReturningFunction(): Unit = {
    println("I don't like returning Unit")
  }
  val theUnit = () // this is what the Unit Type return is
}
