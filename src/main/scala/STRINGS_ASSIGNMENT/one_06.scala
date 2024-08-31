package STRINGS_ASSIGNMENT
//Write a Scala function to check if a given string is a palindrome.
object one_06 {
  def main(args: Array[String]): Unit = {
    var a = scala.io.StdIn.readLine()
    var palindrome = 0
      for(i<-0 to ((a.length/2)-1)){
        if(a(i).toInt != a(a.length-1-i).toInt){
          palindrome -= 1
        }
      }
    if(palindrome <0){
      print("not palindrome")
    }
    else{
      print("palindrome")
    }
  }
}
