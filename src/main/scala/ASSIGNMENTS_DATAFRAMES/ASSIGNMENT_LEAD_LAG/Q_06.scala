package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, sum, min}

//6.Calculate the difference between the current salary and the minimum salary within the last three rows, o
//rdered by id
object Q_06 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_06")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    val employeeData = List(
      (1, "Alice", 1000),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "David", 3000)
    ).toDF("id", "name", "salary")


    val windowSpec = Window.orderBy("id")
      .rowsBetween(-2, 0)

    val rollingSumSalary = employeeData.withColumn(
      "difference",
      col("salary") - min("salary").over(windowSpec)
    ).show()
  }
}
