package assignment_2

object two_26 {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 36){
      if(i % 2 != 0){
        print(i + ", ")
      }
      else{
        print("even, ")
      }
    }
  }
}
