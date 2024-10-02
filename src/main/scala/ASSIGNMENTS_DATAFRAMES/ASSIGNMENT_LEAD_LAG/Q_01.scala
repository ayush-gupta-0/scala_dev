package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_LEAD_LAG

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, to_date, when}

//1. we want to find the difference between the price on each day with it’s previous day.
object Q_01 {
def main(args: Array[String]): Unit = {
  val conf = new SparkConf()
  conf.set("spark.app.name", "Q_01")
  conf.set("spark.master", "local[4]")

  val spark = SparkSession.builder()
    .config(conf)
    .getOrCreate()

  import spark.implicits._
  val data = List(
    (1, "KitKat", 1000.0, "2021-01-01"),
    (1, "KitKat", 2000.0, "2021-01-02"),
    (1, "KitKat", 1000.0, "2021-01-03"),
    (1, "KitKat", 2000.0, "2021-01-04"),
    (1, "KitKat", 3000.0, "2021-01-05"),
    (1, "KitKat", 1000.0, "2021-01-06")
  ).toDF("IT_ID", "IT_Name", "Price", "PriceDate")

  val formattedData = data.select(
    col("IT_ID"),
    col("IT_Name"),
    col("Price"),
    to_date(col("PriceDate") as "PriceDate"
  )
  )
  val windowSpec = Window.orderBy("PriceDate")

  val PreviousPrice = data.withColumn(
    "previous_day_price",
    lag(col("price"), 1)
      .over(windowSpec)
  )

  PreviousPrice.withColumn(
    "difference",
    when(col("price") > col("previous_day_price"), col("price") - col("previous_day_price"))
      .when(col("price") < col("previous_day_price"), col("previous_day_price") - col("price"))
      .when(col("price") === col("previous_day_price"), "no difference")
  ).show()
}
}
