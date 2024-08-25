package ARRAYS_ASSIGNMENT

object one_02 {
 def main(Args:Array[String]):Unit={
   var arr = Array(1, 2, 3, 4, 5)
   var sum = 0
   for(i<- 0 until arr.length){
     sum+=arr(i)
   }
   print(sum)
 }
}
