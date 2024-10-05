package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
//Problem:
//  You have three DataFrames: customers, orders, and products. Join them to find the order details for
//  each customer.
object Q_04_Customer_Order_Details {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_04_Customer_Order_Details")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    // Customers DataFrame
    val customers = Seq(
      ("C001", "Alice"),
      ("C002", "Bob"),
      ("C003", "Charlie"),
      ("C004", "David")
    ).toDF("customer_id", "customer_name")

    // Orders DataFrame
    val orders = Seq(
      ("O001", "C001", "P001"),
      ("O002", "C002", "P002"),
      ("O003", "C003", "P003"),
      ("O004", "C001", "P004"),
      ("O005", "C004", "P001")
    ).toDF("order_id", "customer_id", "product_id")

    // Products DataFrame
    val products = Seq(
      ("P001", "Laptop"),
      ("P002", "Mobile"),
      ("P003", "Tablet"),
      ("P004", "Monitor")
    ).toDF("product_id", "product_name")

    val condition1 = customers("customer_id") === orders("customer_id")
    val condition2 = orders("product_id") === products("product_id")

    val joinType = "inner"

    val joinedDF = customers
      .join(orders, condition1, joinType)
      .drop(customers("customer_id"))
      .join(products, condition2,joinType)
      .drop(products("product_id")).orderBy("customer_name")

    joinedDF.show()


  }
}
