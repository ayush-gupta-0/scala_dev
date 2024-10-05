package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.sum
//Problem:
//  You have two DataFrames: products and sales. Join them to find the total sales amount for each
//  product.
object Q_02_Product_Sales_Analysis {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_02_Product_Sales_Analysis")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Products DataFrame
    val products = Seq(
      ("P001", "Laptop"),
      ("P002", "Mobile"),
      ("P003", "Tablet"),
      ("P004", "Monitor"),
      ("P005", "Keyboard")
    ).toDF("product_id", "product_name")

    // Sales DataFrame
    val sales = Seq(
      ("S001", "P001", 500.0),
      ("S002", "P002", 300.0),
      ("S003", "P001", 700.0),
      ("S004", "P003", 200.0),
      ("S005", "P002", 400.0),
      ("S006", "P004", 600.0),
      ("S007", "P005", 150.0)
    ).toDF("sale_id", "product_id", "amount")

    val condition = sales("product_id") === products("product_id")

    val joinType = "inner"

    val joinedDF = sales.join(products, condition, joinType)
      .drop(products("product_id"))

    joinedDF.show()

    joinedDF.groupBy("product_name").agg(sum("amount") as "total sales of each product").show()

  }
}
