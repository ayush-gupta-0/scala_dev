object one_6_Multiple_Range_Check {
  def main(args:Array[String]):Unit={
    val num = 25
    val b = (1<=num && num<=10) || (20<=num && num<=30)
    print(b)
  }
}
