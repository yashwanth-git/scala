package com.rockthejvm

object FunctionalProgramming extends App{

  // Scala is OO
  class Person(name: String){
    def apply(age: Int): Unit = println(s"I have aged $age years")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Same as bob.apply(43)

  /*
  * Scala runs on the JVM
  * Functional Programming
  * - compose functions
  * - pass functions as arguments
  * - return functions as results
  *
  * Conclusion: FunctionX = Function1, Function2, Function3 ... Function22
  * */

  val simpleIncrementer = new Function1[Int, Int]{
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23)
  simpleIncrementer(23)

  // All Scala functions are instances of FunctionX Types

  val stringConcatenator = new Function2[String, String, String]{
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  // Syntax Sugars
  val doubler: Int => Int = (x: Int) => 2*x
  /**
  val doubler: Function1[Int, Int] = new Function1[Int, Int]{
    override def apply(arg: Int): Int = arg * 2
  }
  **/
  doubler(5)

  // Higher Order Functions = takes functions as arguments/ return function as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x+1) // Higher Order Function
  println(aMappedList)

  // FlatMap
  val aFlatMap = List(1,2,3).flatMap{
    x => List(x, 2*x)
  } // alternative syntax, same as .map(x => List(x, 2*x))
  println(aFlatMap)

  val aFilteredList = List(1,2,3,4,5).filter( _ <=3) // Same as x=> x<=3
  println(aFilteredList)

  // All Pairs between numbers 1,2,3 and a,b,c
  val allPairs = List(1,2,3).flatMap(x => List("a","b","c").map(y => s"$x-$y"))
  println(allPairs)

  // For Comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List("a", "b", "c")
  } yield  s"$number-$letter"
  // equivalent to map/flatMap chain above

  /**
   * Collections
   */

  // Lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtentendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // Sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // aSequence.apply(1) - returns element at index 1

  // Vectors: fast Sequence implementation
  val aVector = Vector(1,2,3,4,5)

  // Sets = No dupes
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4) - avoids dupes
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4,5)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,8...2000)
  println(twoByTwo)

  // Tuples = group of values under the same value
  val aTuple = ("Bon Joyi", "Rock", 1982)

  // Maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 3857213),
    "Jean" -> 23245532 // Same as ("Jean", 23245532)
  )
}
