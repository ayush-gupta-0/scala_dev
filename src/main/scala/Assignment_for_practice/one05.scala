package Assignment_for_practice

object one05 {
  def main(args:Array[String]):Unit={
    for(i <- 1 to 5){
      for(j <- 1 until (2*i)){
        if( j % 2 != 0 ){
          print("*")

        }
        else{
          print("_")
        }
      }
      println()
    }
  }
}
