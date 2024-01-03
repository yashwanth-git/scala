package com.rockthejvm

object PatternMatching extends App {
  // Switch Expression = Pattern Matching
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => anInteger + "th"
  }
  // Pattern Matching is an EXPRESSION
  println(order)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43) // Person.apply("Bob",43)
  // Case Class Decomposition
  val personGreeting = bob match {
    case Person(n,a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }

  println(personGreeting)

  // Tuple Deconstruction
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }
  println(bandDescription)

  // List Decompostion
  val aList = List(1, 2,3)
  val listDescription = aList match{
    case List(_,2,_) => "The list contains 2 on its second position"
    case _ => "Unknown list"
  }
  // if PM doesn't match anything, it will throw an MatchError that's why we add default case
  // PM will try all cases in sequence
  println(listDescription)
}
