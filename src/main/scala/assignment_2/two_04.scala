package assignment_2

object two_04 {
  def main(args:Array[String]):Unit={
    val num = 99

    if(100 <= num && num <= 1000){
      if(num % 2 == 0){
        println("even")
        println(num % 3)
      }
      else{
        println("odd")
        println(num % 2)
      }
    }
    else{
      print("wrong number")
    }
  }
}
