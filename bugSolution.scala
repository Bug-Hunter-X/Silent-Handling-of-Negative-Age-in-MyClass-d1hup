```scala
class MyClass(val name: String) {
  private var _age: Int = 0

  def age: Int = _age
  def age_=(newAge: Int): Unit = {
    if (newAge >= 0) {
      _age = newAge
    } else {
      throw new IllegalArgumentException("Age cannot be negative.")
    }
  }
}

object Main extends App {
  val person = new MyClass("John")
  try {
    person.age = -5 // Corrected: Throws exception if age is negative
  } catch {
    case e: IllegalArgumentException => println(e.getMessage)
  }
  println(person.age) // Output: 0
}
```