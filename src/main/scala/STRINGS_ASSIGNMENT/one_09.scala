package STRINGS_ASSIGNMENT

object one_09 {
  def main(args:Array[String]): Unit = {
    var a = scala.io.StdIn.readLine()
    var b = a.split(' ')
    for(i<- b.indices){
      print(b(i))
    }
  }
}
