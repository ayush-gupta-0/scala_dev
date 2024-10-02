package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{sum, max}

//12.Find the maximum salary for each employee’s group (partitioned by name) and display it for each row.
object Q_12 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_08")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    val employeeData = List(
      (1, "Alice", 1000),
      (1, "Alice", 100),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "David", 3000)
    ).toDF("id", "name", "salary")


    val windowSpec = Window.partitionBy("name").orderBy("id")

    val leadLagSalary = employeeData.withColumn(
      "max_salary",
      max("salary").over(windowSpec)
    )

    leadLagSalary.show()

  }
}
