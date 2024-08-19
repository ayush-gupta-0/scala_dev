package assignment_2

object two_05 {
  def main(args:Array[String]):Unit={
    val num = 34

    if(0 <= num && num <= 100){
      if(91 <= num && num <= 100){
        println("super smart")
      }
      else if(81 <= num && num <= 90){
        println("smart")
      }
      else if(71 <= num && num <= 80){
        println("smart enough")
      }
      else if(61 <= num && num <= 70){
        println("just smart")
      }
      else if(36 <= num && num <= 60){
        println("no smart")
      }
      else if(0 <= num && num <= 35){
        println("dump")
      }
    }
    else{
      print("invalid input")
    }
  }
}
