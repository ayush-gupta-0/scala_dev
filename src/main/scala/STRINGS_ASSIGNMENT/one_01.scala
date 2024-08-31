package STRINGS_ASSIGNMENT
//Write a Scala function to count the occurrences of a specific character in a given string.
object one_01 {
  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine()
    val b = scala.io.StdIn.readChar()
    var count = 0
    for(i<- 0 until a.length){
      if(a(i) == b){
        count += 1
      }
    }
    print(count)
  }
}
