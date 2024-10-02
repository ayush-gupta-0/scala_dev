package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{abs, col, count, lag, lead, sum, when}

//10.Calculate the cumulative count of employees, ordered by id, and reset the count when the name chan
//ges.
object Q_10 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_10")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    val employeeData = List(
      (1, "Alice", 1000),
      (1, "Alice", 1000),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "David", 3000)
    ).toDF("id", "name", "salary")


    val windowSpec = Window.partitionBy("name").orderBy("id")

    val leadLagSalary = employeeData.withColumn(
      "cumulative_column",
      count("id").over(windowSpec)
    )

    leadLagSalary.show()

  }
}
