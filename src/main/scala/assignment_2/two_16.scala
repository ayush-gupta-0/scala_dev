package assignment_2

object two_16 {
  def main(args: Array[String]): Unit = {
    var sum = 0
    for(i <- 383 to 581){
      if(i % 2 == 0){
        sum += i
      }
    }
    print(sum)
  }
}
