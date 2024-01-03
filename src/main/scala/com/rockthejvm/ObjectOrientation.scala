package com.rockthejvm

object ObjectOrientation extends App{
  // Class
  class Animal{
    // Field
    val age: Int = 0
    // Method
    def eat() = println("I'm eating")
  }

  // Instance
  val anAnimal = new Animal

  // Inheritance
  class Dog extends Animal

  // Constructor definition
  class Cat(val name: String) extends Animal

  // Constructor Arguments are not fields
  // Here name is just a constructor and not a field
  // that can be accessed using aCat.name

  // If you need that change name to val name
  val aCat = new Cat("Heath")
  aCat.name

  // Subtype Polymorphism
  val aDeclaredAnimal: Animal = new Cat("Hatchi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // Abstract Class - does not have any implementation just has declaration
  // All fields and methods are public by default,
  // it can be restricted by adding protected or private
  abstract class WalkingAnimal {
    val hasLegs = true
    def walk(): Unit
  }

  // Interface = ultimate abstract class = leave everything unimplemented
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher{
    def ?!(thought: String): Unit // Valid Method name = ?!
  }

  // Single Class Inheritance, Multi trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher { // add more with here to have more traits
    override def eat(animal: Animal): Unit = println("I'm eating you, animal")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aCat) // Same as below
  aCroc eat aCat // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if I can talk to dogs" // Same as aCroc.?!("What if I can talk to dogs")

  // Operators in Scala are actually methods
  val basicAdd = 1 + 2
  val anotherBasicAdd = 1.+(2)

  // Anonymous Classes
  /* this is what happens under the hood

   class Carnivore_Anonymous_12433 extends Carnivore{
    override def eat(animal: Animal): Unit = println("I am dinosaur so I can pretty much eat anything")
   }
   val dinosaur = new Carnivore_Anonymous_12433

  * */
  val dinosaur = new Carnivore {
      override def eat(animal: Animal): Unit = println("I am dinosaur so I can pretty much eat anything")
  }

  // Singleton Object
  object MySingleton { // Only instance of MySingleton type
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x+1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // Same as MySingleton.apply(65) - apply can be invoked like functions in Singleton

  object Animal { // companions - companion object
    // Companions can access each other's private fields/methods
    // Singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "Static" fields/methods

  /* Case Classes = lightweight data structures with some boilerplate
  *   Sensible equals and hash code
  *   Serialization
  *   Companion with Apply
  *   Pattern Matching
  * */
  case class Person(name: String, age: Int)

  // May be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // Exceptions
  try{
    // Code that can throw
    val x: String = null
    x.length
  }
  catch{
    case e: Exception => "Some faulty error message"
  }
  finally{
    // execute some code no matter what
  }

  // Generics
  abstract class MyList[T]{
    def head: T
    def tail: MyList[T]
  }

  // Using a Generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // Int
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head //String

  // Point 1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER Object
  /*
  * Benefits
  * 1. Works miracles in multithreaded/distributed env
  * 2. helps making sense of the code ("Reasoning About")
  * */
  val reversedList = aList.reverse // returns a NEW List

  // Point 2: Scala is closest to the OO ideal

}

