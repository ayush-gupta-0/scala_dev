object one_29_Check_for_Non_Negative_AND_Not_Divisible_by_7 {
  def main(args:Array[String]):Unit={
    val a = 14
    val b = a>(-1) && !(a%7==0)
    print(b)
  }
}
