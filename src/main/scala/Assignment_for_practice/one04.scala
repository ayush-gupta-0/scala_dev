package Assignment_for_practice

object one04 {
  def main(args:Array[String]):Unit={
    val v = 4
    val h = 6
    for(i <- 1 to v){
      if(i == 1 || i == v){
        print("* " * h)
      }
      else{
        for(j <- 1 to h){
          if(j == 1 || j == h){
            print("* ")
          }
          else{
            print("  ")
          }
        }
      }
      println()
    }
  }
}
