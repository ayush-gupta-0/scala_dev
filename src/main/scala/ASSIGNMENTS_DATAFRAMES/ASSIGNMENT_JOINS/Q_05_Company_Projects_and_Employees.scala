package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
//Problem:
//  You have three DataFrames: projects, employees, and assignments. Join them to find the employees
//  assigned to each project.
object Q_05_Company_Projects_and_Employees {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_05_Company_Projects_and_Employees")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    // Projects DataFrame
    val projects = Seq(
      ("PR001", "Project Alpha"),
      ("PR002", "Project Beta"),
      ("PR003", "Project Gamma")
    ).toDF("project_id", "project_name")

    // Employees DataFrame
    val employees = Seq(
      ("E001", "Alice"),
      ("E002", "Bob"),
      ("E003", "Charlie"),
      ("E004", "David")
    ).toDF("employee_id", "employee_name")

    // Assignments DataFrame
    val assignments = Seq(
      ("A001", "PR001", "E001"),
      ("A002", "PR001", "E002"),
      ("A003", "PR002", "E001"),
      ("A004", "PR003", "E003"),
      ("A005", "PR003", "E004")
    ).toDF("assignment_id", "project_id", "employee_id")

    val condition1 = projects("project_id") === assignments("project_id")
    val condition2 = assignments("employee_id") === employees("employee_id")

    val joinType = "inner"

    val joinedDF = projects
      .join(assignments, condition1, joinType)
      .drop(projects("project_id"))
      .join(employees, condition2,joinType)
      .drop(employees("employee_id"))

    joinedDF.show()

    }
}
