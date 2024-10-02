package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead}

object Q_03 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_03")
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

    employeeData.withColumn(
      "LeadSalary",
      lead(col("salary"), 1).over(windowSpec)
    ).withColumn(
      "LagSalary",
      lag(col("salary"), 1).over(windowSpec)
    ).show()
  }
}
