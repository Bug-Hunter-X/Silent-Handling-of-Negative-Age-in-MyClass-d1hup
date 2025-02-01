```scala
class MyClass(val name: String) {
  private var _age: Int = 0

  def age: Int = _age
  def age_=(newAge: Int): Unit = {
    if (newAge >= 0) {
      _age = newAge
    } else {
      // Here's the bug: No explicit exception is thrown for negative age.
      println("Age cannot be negative. Setting to 0.")
      _age = 0
    }
  }
}

object Main extends App {
  val person = new MyClass("John")
  person.age = -5 // Bug: Negative age is silently set to 0.
  println(person.age) // Output: 0
}
```