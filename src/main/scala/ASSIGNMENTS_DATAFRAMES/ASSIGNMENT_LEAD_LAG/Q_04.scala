package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, when}
//Calculate the percentage change in salary from the previous row to the current row, ordered by id.
//(using the same sample data)

object Q_04 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_04")
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

//    employeeData.withColumn("lagSalary",
//      lag(col("salary"), 1).over(windowSpec)
//    ).show()



    employeeData.withColumn(
        "percentage_salary_change",
        when(col("salary") > lag(col("salary"), 1).over(windowSpec), (col("salary") - lag(col("salary"), 1).over(windowSpec))*100/col("salary"))
          .when(col("salary") < lag(col("salary"), 1).over(windowSpec), (lag(col("salary"), 1).over(windowSpec) - col("salary"))*100/lag(col("salary"), 1).over(windowSpec))
          .otherwise("nochange")
      ).show()


  }
}
