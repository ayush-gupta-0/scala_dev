package assignment_1

object one_03 {
  def main(args:Array[String]):Unit={
    var sum = 0
    for(i <- 1 to 50){
      sum = sum+i
    }
    print(sum)
  }
}
