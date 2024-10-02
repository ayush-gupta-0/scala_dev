package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, min, when}

//7.Calculate the lead and lag of salary within each group of employees (grouped by name) ordered by id
object Q_07 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_07")
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

    val leadLagSalary = employeeData.select(
      col("id"),
      col("name"),
      col("salary"),
      lead(col("salary"), 1).over(windowSpec).as("leadSalary"),
      lag(col("salary"), 1).over(windowSpec).as("lagSalary")
    )

    leadLagSalary.show()

  }
}
