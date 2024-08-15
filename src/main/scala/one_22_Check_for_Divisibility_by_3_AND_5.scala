object one_22_Check_for_Divisibility_by_3_AND_5 {
  def main(args:Array[String]):Unit={
    val a = 15
    val b = a%3==0 && a%5==0
    print(b)
  }
}
