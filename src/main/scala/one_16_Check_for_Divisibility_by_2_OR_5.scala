object one_16_Check_for_Divisibility_by_2_OR_5 {
  def main(args:Array[String]):Unit={
    val a = 25
    val b = a%2==0 || a%5==0
    print(b)
  }
}
