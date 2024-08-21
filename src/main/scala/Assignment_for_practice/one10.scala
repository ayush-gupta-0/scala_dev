package Assignment_for_practice

object one10 {
  def main(args:Array[String]):Unit={
    var rows = 5
    for(i <- 1 to rows){
      print(" " * (2*(rows-i)))
      for(j <- 1 until 2*i){
        print("* ")
      }
      println()
    }
  }
}
