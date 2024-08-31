package STRINGS_ASSIGNMENT
// Write a Scala function to find the length of the longest word in a sentence.
object one_04 {
 def main(args:Array[String]):Unit={
   var stnc = scala.io.StdIn.readLine()
   var length = 0

   val a = (stnc.split(' '))
   for(i<- 0 until a.length){
     if(a(i).length > length){
       length = a(i).length
     }
   }
   print(length)
 }
}
