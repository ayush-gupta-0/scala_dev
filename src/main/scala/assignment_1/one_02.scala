package assignment_1

object one_02 {
  def main(args:Array[String]):Unit={
    var a = 2
    while(a <= 10){
      if(a%2==0){
        println(a)
      }
      a = a + 1
    }
  }
}
