package ARRAYS_ASSIGNMENT

object one_04 {
  def main(Args:Array[String]):Unit={
    var arr = new Array[Double](5)
    for(i<- 0 until arr.length){
      arr(i) = scala.io.StdIn.readDouble()
    }
    var big:Double = 0
    for(i<- 0 until arr.length){
      if(arr(i)>big){
        big = arr(i)
      }

    }
    print(big)
  }
}
