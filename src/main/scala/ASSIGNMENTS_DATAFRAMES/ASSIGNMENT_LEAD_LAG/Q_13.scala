package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{abs, avg, col, max}

//13.Calculate the difference between the current salary and the average salary for each employee’s group
//(partitioned by name) ordered by id.
object Q_13 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_13")
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
      "difference",
      abs(col("salary") - avg("salary").over(windowSpec))
    )

    leadLagSalary.show()

  }
}
