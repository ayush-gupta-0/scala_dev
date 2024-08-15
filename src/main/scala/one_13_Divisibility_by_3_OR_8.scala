object one_13_Divisibility_by_3_OR_8 {
  def main(args:Array[String]):Unit={
    val a = 24
    val b = a%3==0 || a%8==0
    print(b)
  }
}
