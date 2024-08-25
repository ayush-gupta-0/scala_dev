package ARRAYS_ASSIGNMENT

object one_07 {
  def main(Args:Array[String]):Unit={
    val arr = Array("1a", "2b", "3c", "4d", "5e")
    val toFind = "3dc"
    var inArray = false
    for(i <- 0 until arr.length){
      if(arr(i) == toFind){
        inArray = true
        print(inArray)
        return
      }
    }
    print(inArray)
  }
}
