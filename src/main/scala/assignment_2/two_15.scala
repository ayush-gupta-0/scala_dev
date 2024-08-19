package assignment_2

object two_15 {
  def main(args:Array[String]):Unit={
    for(i <- 2 to 16){
      print(i + "*" + (i+1) + "=" + (i*(i+1)) + ", ")
    }
  }
}
