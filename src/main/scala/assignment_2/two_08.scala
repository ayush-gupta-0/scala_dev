package assignment_2

object two_08 {
  def main(args:Array[String]):Unit={
    for(i <- 250 to 550){
      if(i % 11 == 0){
        print(i + " ")
      }
    }
  }
}
