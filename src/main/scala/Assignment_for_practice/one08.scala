package Assignment_for_practice

object one08 {
  def main(args:Array[String]):Unit={
    val n = 4
    for(i <- 1 to n){
      if(i==n){
        println("*" * ((2*n)-1))
      }
      else{
        println("*" * i + " " * ((2*n-1) - (2*i)) + "*" * i)
      }
    }
    for(i <- n-1 to 1 by -1){
      println("*" * i + " " * ((2*n-1) - (2*i)) + "*" * i)
    }
  }
}
