package assignment_2

object two_13 {
  def main(args:Array[String]):Unit={
    val a = 20
    var l1 = 0
    if(a % 2 == 0){
      l1 = a
    }
    else{
      l1 = a+1
    }
    for(i <- l1 to 140 by 4){
      print(i + " ")
    }
  }
}
