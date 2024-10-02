package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.sum

//5.Calculate the rolling sum of salary for the current row and the previous two rows, ordered by id
object Q_05 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_05")
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
      "rollingSumSalary",
      sum("salary").over(windowSpec)
    ).show()
  }
}
