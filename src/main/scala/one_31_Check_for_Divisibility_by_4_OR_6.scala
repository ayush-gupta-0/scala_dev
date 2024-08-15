object one_31_Check_for_Divisibility_by_4_OR_6 {
  def main(args:Array[String]):Unit={
    val a = 24
    val b = a%4==0 || a%6==0
    print(b)
  }
}
