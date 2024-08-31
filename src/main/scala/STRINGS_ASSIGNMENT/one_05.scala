package STRINGS_ASSIGNMENT
//Create a Scala function to check if two strings are anagrams.
//using hashmap
object one_05 {
  def main(args:Array[String]):Unit={
    val a = scala.io.StdIn.readLine()
    val b = scala.io.StdIn.readLine()
    var same = 0
    var different = 0

    var aHash = new Array[Int](122)
    var bHash = new Array[Int](122)

    for(i<-0 until a.length){
      aHash(a(i).toInt) += 1
    }
    for(i<-0 until b.length){
      bHash(b(i).toInt) += 1
    }
    for(i<- 65 until aHash.length){
      if(aHash(i) == bHash(i)){
        same += 1
      }
      else if(aHash(i) != bHash(i)){
        different += 1
      }
    }
    if(different == 0){
      print("anagram")
    }
    else{
      print("not an anagram")
    }
  }
}
