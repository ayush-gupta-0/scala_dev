package ARRAYS_ASSIGNMENT

object one_01 {
  def main(args:Array[String]):Unit={
    var arr = Array(1, 2, 3, 4, 5)
    for(i<- 0 until arr.length){
      print(arr(i) +" ")
    }
  }
}
