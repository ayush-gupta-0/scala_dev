package STRINGS_ASSIGNMENT
//Given a string, write a Scala function to convert it to uppercase.
object one_03 {
  def main(args: Array[String]): Unit = {
    val str= scala.io.StdIn.readLine()
    var str2 = new Array[Char] (str.length)

    for(i <- 0 until str.length){
      var a = str(i).toInt
      if(a >= 97 && a <= 122){
        var b = (a - 32).toChar
        str2(i) = b
      }
      else{
        str2(i) = str(i)
      }
      print(str2(i))
    }
  }
}
