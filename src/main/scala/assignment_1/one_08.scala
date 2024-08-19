package assignment_1

object one_08 {
  def main(args:Array[String]):Unit= {
    var a = 5
    var fact = 1
    for(i <- 1 to a){
      fact = fact*i
    }
    print(fact)
  }
}
