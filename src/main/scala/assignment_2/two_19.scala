package assignment_2

object two_19 {
  def main(args: Array[String]): Unit = {
    var sum = 0
    for(i <- 5 to 102){
      sum += i*i
    }
    print(sum)
  }
}
