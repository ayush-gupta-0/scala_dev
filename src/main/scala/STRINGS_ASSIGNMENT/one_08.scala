package STRINGS_ASSIGNMENT
//Given a string, write a Scala function to reverse the order of words in it.
object one_08 {
  def main(args:Array[String]): Unit = {
    var a = scala.io.StdIn.readLine()
    var dl = ' '
    var b = a.split(dl)
    for(i<-(b.length-1) to 0 by -1){
      print(b(i) + " ")
    }
  }
}
