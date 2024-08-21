package Assignment_for_practice

object one03 {
  def main(args:Array[String]):Unit={
    for(i <- 5 to 1 by -1){
      for(j <- 1 to i){
        print("* ")
      }
      println()
    }
  }
}
