package ARRAYS_ASSIGNMENT

object one_09 {
  def main(Args:Array[String]):Unit={
    var arr = new Array[Int](5)
    for(i<- arr.indices){
      arr(i) = scala.io.StdIn.readInt()
    }
    var smaller = Int.MaxValue
    var smallest = Int.MaxValue
    for(i<- arr.indices){
      if(arr(i)<smallest){
        smaller = smallest
        smallest = arr(i)
      }
      if(arr(i)<smaller && arr(i)> smallest){
        smaller = arr(i)
      }
    }
    print(smaller + " " + "smallest = " + smallest)
  }
}
