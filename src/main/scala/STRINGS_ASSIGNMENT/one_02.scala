package STRINGS_ASSIGNMENT
// Implement a Scala function to concatenate two strings without using the + operator.
object one_02 {
  def main(args:Array[String]): Unit ={
    val str1 = scala.io.StdIn.readLine()
    val str2 = scala.io.StdIn.readLine()

    val strMerge = new Array[Char] (str1.length + str2.length)


    for(i<-0 until str1.length){
      strMerge(i) = str1(i)
    }
    for(i<-0 until str2.length){
      strMerge(str1.length+i) = str2(i)
    }
    for(i<-0 until strMerge.length){
      print(strMerge(i))
    }

  }
}
