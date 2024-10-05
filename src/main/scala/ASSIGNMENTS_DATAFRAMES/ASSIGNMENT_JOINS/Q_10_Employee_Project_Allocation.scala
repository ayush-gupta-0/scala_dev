package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
//Problem:
//  You have four DataFrames: employees, projects, allocations, and departments. Join them to find
//  which employees are allocated to which projects along with their department names.
object Q_10_Employee_Project_Allocation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_10_Employee_Project_Allocation")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Employees DataFrame
    val employees = Seq(
      ("E001", "Alice", "D001"),
      ("E002", "Bob", "D002"),
      ("E003", "Charlie", "D001"),
      ("E004", "David", "D003"),
      ("E005", "Eve", "D002")
    ).toDF("employee_id", "employee_name", "department_id")

    // Projects DataFrame
    val projects = Seq(
      ("PR001", "Project Alpha"),
      ("PR002", "Project Beta"),
      ("PR003", "Project Gamma")
    ).toDF("project_id", "project_name")

    // Allocations DataFrame
    val allocations = Seq(
      ("A001", "E001", "PR001"),
      ("A002", "E002", "PR002"),
      ("A003", "E001", "PR003"),
      ("A004", "E003", "PR001"),
      ("A005", "E004", "PR003"),
      ("A006", "E005", "PR002")
    ).toDF("allocation_id", "employee_id", "project_id")

    // Departments DataFrame
    val departments = Seq(
      ("D001", "HR"),
      ("D002", "Finance"),
      ("D003", "IT")
    ).toDF("department_id", "department_name")

    val condition1 = employees("employee_id") === allocations("employee_id")
    val condition2 = employees("department_id") === departments("department_id")
    val condition3 = allocations("project_id") === projects("project_id")

    val joinType = "inner"

    val joinedDF = employees
      .join(allocations, condition1, joinType)
      .drop(allocations("employee_id"))
      .join(departments, condition2, joinType)
      .drop(employees("department_id"))
      .join(projects, condition3, joinType)
      .drop(allocations("project_id"))

    joinedDF.show()
  }
}
