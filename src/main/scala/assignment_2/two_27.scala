package assignment_2

object two_27 {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 24){
      if(i % 3 != 0){
        print(i + ", ")
      }
      else{
        print("factor of three, ")
      }
    }
  }
}
