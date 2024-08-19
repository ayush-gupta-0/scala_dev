package assignment_2

object two_12 {
  def main(args:Array[String]):Unit={
    val l1 = 1
    val l2 = 70
    var count = 0
    for(i <- l1 to l2){
      if(i % 2 == 0){
        count += 1
      }
    }
    print(count)
  }
}
