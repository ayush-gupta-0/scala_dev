package assignment_1

object one_12 {
  def main(args:Array[String]):Unit= {
    var i = 1
    var sum = 0
    while(i <= 20){
      if(i%2==0){
        sum = sum + i
      }
      i += 1
    }
    print(sum)
  }
}
