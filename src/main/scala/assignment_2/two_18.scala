package assignment_2

object two_18 {
  def main(args: Array[String]): Unit = {
    var sum = 0
    var count = 0
    for(i <- 24 to 100 by 2){
      sum += i
      count += 1
    }
    print(sum/count)
  }
}
