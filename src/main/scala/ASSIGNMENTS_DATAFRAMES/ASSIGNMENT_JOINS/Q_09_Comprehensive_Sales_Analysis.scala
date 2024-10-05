package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.avg

//Problem:
//  You have four DataFrames: customers, orders, products, and regions. Join them to find the sales
//  amount for each customer along with their region.
object Q_09_Comprehensive_Sales_Analysis {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_09_Comprehensive_Sales_Analysis")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Customers DataFrame
    val customers = Seq(
      ("C001", "Alice", "R001"),
      ("C002", "Bob", "R002"),
      ("C003", "Charlie", "R003"),
      ("C004", "David", "R001"),
      ("C005", "Eve", "R004")
    ).toDF("customer_id", "customer_name", "region_id")

    // Orders DataFrame
    val orders = Seq(
      ("O001", "C001", "P001"),
      ("O002", "C002", "P002"),
      ("O003", "C001", "P003"),
      ("O004", "C003", "P001"),
      ("O005", "C004", "P004"),
      ("O006", "C005", "P002"),
      ("O007", "C005", "P003")
    ).toDF("order_id", "customer_id", "product_id")

    // Products DataFrame
    val products = Seq(
      ("P001", "Laptop", 800.0),
      ("P002", "Mobile", 400.0),
      ("P003", "Tablet", 300.0),
      ("P004", "Monitor", 200.0)
    ).toDF("product_id", "product_name", "price")

    // Regions DataFrame
    val regions = Seq(
      ("R001", "North"),
      ("R002", "South"),
      ("R003", "East"),
      ("R004", "West")
    ).toDF("region_id", "region_name")

    val condition1 = customers("customer_id") === orders("customer_id")
    val condition2 = customers("region_id") === regions("region_id")
    val condition3 = orders("product_id") === products("product_id")

    val joinType = "inner"

    val joinedDF = customers
      .join(orders, condition1, joinType)
      .drop(orders("customer_id"))
      .join(regions, condition2,joinType)
      .drop(regions("region_id"))
      .join(products, condition3,joinType)
      .drop(products("product_id"))

    joinedDF.show()
  }
}
