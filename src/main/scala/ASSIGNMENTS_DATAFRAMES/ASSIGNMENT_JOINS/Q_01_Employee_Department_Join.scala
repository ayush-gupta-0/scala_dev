package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Q_01_Employee_Department_Join {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_01_Employee_Department_Join")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    //DataFrames:
    // Employees DataFrame
    val employees = Seq(
      ("E001", "Alice", "D001"),
      ("E002", "Bob", "D002"),
      ("E003", "Charlie", "D001"),
      ("E004", "David", "D003"),
      ("E005", "Eve", "D002"),
      ("E006", "Frank", "D001"),
      ("E007", "Grace", "D004")
    ).toDF("employee_id", "employee_name", "department_id")

    // Departments DataFrame
    val departments = Seq(
      ("D001", "HR"),
      ("D002", "Finance"),
      ("D003", "IT"),
      ("D004", "Marketing"),
      ("D005", "Sales")
    ).toDF("department_id", "department_name")

    val condition = employees("department_id") === departments("department_id")

    val joinType = "inner"

    val joinedDF = employees.join(departments, condition, joinType)
      .drop(departments("department_id"))

    joinedDF.show()
  }
}
