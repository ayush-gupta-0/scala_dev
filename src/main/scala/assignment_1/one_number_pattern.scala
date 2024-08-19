package assignment_1

object one_number_pattern {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 4){
      for(j <- 1 to i){
        print(i)
      }
      println()
    }
//    for(i <- 1 to 4){
//      var j = 1
//      while(j <= i){
//        print(i)
//        j += 1
//      }
//      println()
//    }
  }
}
