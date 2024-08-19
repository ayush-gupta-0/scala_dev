package assignment_1

object one_18 {
  def main(args: Array[String]): Unit = {
    var a = 2
    var i = 1
    if(a<0){
      print("negative numbers cannot be perfect squares")
      return
    }
    if(a == 0 || a == 1){
      print("perfect square")
      return
    }
    while(i*i <= a){
      if(i*i == a){
        print("perfect square")
        return
      }
      else{
        i += 1
      }
    }
    print("not a perfect square")
  }
}
