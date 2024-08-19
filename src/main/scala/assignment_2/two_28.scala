package assignment_2

object two_28 {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 25 by 2){
      if(i % 5 != 0){
        print(i + ", ")
      }
      else{
        print("divisible by five, ")
      }
    }
  }
}
