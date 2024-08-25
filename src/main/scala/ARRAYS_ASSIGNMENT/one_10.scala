package ARRAYS_ASSIGNMENT

object one_10 {
  def main(Args:Array[String]):Unit={
    var arr = new Array[Int](5)
    var asc = true
    for(i<- arr.indices){
      arr(i) = scala.io.StdIn.readInt()
    }
    for(i<- 0 until arr.length-1){
      if(arr(i)>arr(i+1)){
        print("not in ascending order")
        asc = false
        return
      }
    }
    if(asc){
      print("ascending")
    }
  }
}
