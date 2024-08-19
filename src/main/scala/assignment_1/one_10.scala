package assignment_1

object one_10 {
  def main(args:Array[String]):Unit= {
    val a = 14
    var i = 2
    var prime = true
    if (a == 1){
      print("non-prime")
    }
    else {
      while (i <= a / 2) {
        if (a % i == 0) {
          i = i + 1
          prime = false
        }
        else{
          i=i+1
        }
      }
    }
    if (prime) {
        print("prime")
      }
      else {
        print("non-prime")
      }
    }
}
