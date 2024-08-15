object one_11_Check_for_Prime_AND_Odd_Number {
  def main(args:Array[String]):Unit={
    val a = 17

    for (i <- 2 to a/2){
      if(a%i==0){
        val b = a%2!=0
        print(b)
      }
    }
  }
}
