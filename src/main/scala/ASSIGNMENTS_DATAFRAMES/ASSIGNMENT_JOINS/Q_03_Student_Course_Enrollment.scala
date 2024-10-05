package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.sum
//Problem:
//  You have two DataFrames: students and courses. Join them to find the courses each student is
//  enrolled in.
object Q_03_Student_Course_Enrollment {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_03_Student_Course_Enrollment")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Students DataFrame
    val students = Seq(
      ("S001", "John"),
      ("S002", "Emma"),
      ("S003", "Olivia"),
      ("S004", "Liam"),
      ("S005", "Noah")
    ).toDF("student_id", "student_name")

    // Courses DataFrame
    val courses = Seq(
      ("C001", "Math"),
      ("C002", "Science"),
      ("C003", "History"),
      ("C004", "Art")
    ).toDF("course_id", "course_name")

    // Enrollments DataFrame
    val enrollments = Seq(
      ("E001", "S001", "C001"),
      ("E002", "S002", "C002"),
      ("E003", "S001", "C003"),
      ("E004", "S003", "C001"),
      ("E005", "S004", "C004"),
      ("E006", "S005", "C002"),
      ("E007", "S005", "C003")
    ).toDF("enrollment_id", "student_id", "course_id")

    val condition1 = students("student_id") === enrollments("student_id")
    val condition2 = enrollments("course_id") === courses("course_id")

    val joinType = "inner"

    val joinedDF = students.join(enrollments, condition1, joinType)
      .drop(students("student_id")).join(courses, condition2,joinType).drop(courses("course_id"))

    joinedDF.show()
    


  }
}
