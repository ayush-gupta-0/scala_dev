package STRINGS_ASSIGNMENT
//Implement a Scala function to count the number of vowels in a given string.
object one_07 {
  def main(args: Array[String]): Unit = {
    var a = scala.io.StdIn.readLine()
    var count = 0
    for(i<- 0 until a.length){
      a(i) match{
        case 'a' => count += 1
        case 'e' => count += 1
        case 'i' => count += 1
        case 'o' => count += 1
        case 'u' => count += 1
        case 'A' => count += 1
        case 'E' => count += 1
        case 'I' => count += 1
        case 'U' => count += 1
        case _ => count += 0
      }
    }
    print(count)
  }
}
