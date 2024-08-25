package ARRAYS_ASSIGNMENT

object one_05 {
  def main(Args:Array[String]):Unit={
    val arr1 = Array(31, 43, 12, 54, 63)
    val arr2 = Array(32, 46, 17, 58, 74, 64)
    val lenTotal = arr1.length + arr2.length
    val arrMerge = new Array[Int] (lenTotal)

    for(i<-0 until arr1.length){
        arrMerge(i) = arr1(i)
    }
    for(i<-0 until arr2.length){
      arrMerge(arr1.length+i) = arr2(i)
    }
    for(i<-0 until arrMerge.length){
      print(arrMerge(i)+", ")
    }
  }
}
