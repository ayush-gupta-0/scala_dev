package assignment_2

object two_03 {
  def main(args:Array[String]):Unit={
    var a = 1
    var b = 3
    var c = 5

    if(a>=b){
      if(a>=c){
        print("a" + a)
      }
      else{
        print("c" + c)
      }
    }
    else{
      if(b>=c){
        print("b" + b)
      }
      else{
        print("c" + c)
      }
    }
  }
}
