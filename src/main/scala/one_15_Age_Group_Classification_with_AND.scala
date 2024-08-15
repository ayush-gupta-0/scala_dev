object one_15_Age_Group_Classification_with_AND {
  def main(args:Array[String]):Unit={
    val a = 15
    if(a<13){
      print("child")
    }
    else if(a>=13 && a<=19){
      print("teenager")
    }
    else{
      print("adult")
    }
  }
}
