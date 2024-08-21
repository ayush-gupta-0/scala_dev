package Assignment_for_practice

object one06 {
  def main(args:Array[String]):Unit={
    for(i <- 1 to 5){
      print(" " * (2*(5-i)))
      for(j <- 1 until 2*i){
        print("* ")
      }
      println()
    }
    for(i <- 4 to 1 by -1){
      print(" " * (2*(4-i+1)))
      for(j <- 1 until 2*i){
        print("* ")
      }
      println()
    }
  }
}
