package assignment_2

object two_21 {
  def main(args: Array[String]): Unit = {
    for(i <- 10 to -5 by -1){
      print(i + "@" + (i-1) + " ")
    }
  }
}
