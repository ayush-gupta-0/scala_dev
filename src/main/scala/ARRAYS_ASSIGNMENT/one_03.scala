package ARRAYS_ASSIGNMENT

object one_03 {
  def main(Args:Array[String]):Unit={
    var arr = Array("1", "2", "3", "4", "5")
    for(i<- arr.length-1 to 0 by -1){
      print(arr(i) + ", ")
    }

  }
}
