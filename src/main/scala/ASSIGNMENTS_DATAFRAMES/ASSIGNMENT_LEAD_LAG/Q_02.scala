package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, date_format, month, to_date}
//2. If salary is less than previous month we will mark it as "DOWN", if salary has increased then "UP"
object Q_02 {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_02")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    val data = List(
      (1, "John", 1000, "01/01/2016"),
      (1, "John", 2000, "02/01/2016"),
      (1, "John", 1000, "03/01/2016"),
      (1, "John", 2000, "04/01/2016"),
      (1, "John", 3000, "05/01/2016"),
      (1, "John", 1000, "06/01/2016")
    ).toDF("ID", "NAME", "SALARY", "DATE")

    val formattedData = data.select(
      col("ID"),
      col("NAME"),
      col("SALARY"),
      to_date(col("DATE"), "MM/dd/yyyy") as "DATE"
    )
    formattedData.show()

    formattedData.printSchema()

    val extractMonth = formattedData.withColumn(
      "MONTH",
      month(col("DATE"))
    )
    extractMonth.show()
    extractMonth.createOrReplaceTempView("formattedData")

    spark.sql(
      """

        select *,
        lag(salary, 1) over(order by month) as previous_month_salary,
        case
        when salary < lag(salary, 1) over(order by month) then "down"
        when salary > lag(salary, 1) over(order by month) then "up"
        else "no change"
        end as change
        from formattedData

        """).show()
  }
}
