package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
//Problem:
//  You have two DataFrames: patients and visits. Join them to find the visit details for each patient.
object Q_06_Hospital_Patient_Visits {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_06_Hospital_Patient_Visits")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._
    // Patients DataFrame
    val patients = Seq(
      ("P001", "Alice", 30),
      ("P002", "Bob", 40),
      ("P003", "Charlie", 25)
    ).toDF("patient_id", "patient_name", "age")

    // Visits DataFrame
    val visits = Seq(
      ("V001", "P001", "2024-01-01", "Routine Checkup"),
      ("V002", "P002", "2024-01-05", "Consultation"),
      ("V003", "P001", "2024-01-10", "Follow-up"),
      ("V004", "P003", "2024-01-12", "Emergency"),
      ("V005", "P001", "2024-01-15", "Routine Checkup")
    ).toDF("visit_id", "patient_id", "visit_date", "visit_reason")

    val condition1 = patients("patient_id") === visits("patient_id")

    val joinType = "inner"

    val joinedDF = patients
      .join(visits, condition1, joinType)
      .drop(visits("visit_id"))
      .drop(visits("patient_id"))
      .orderBy("patient_name")

    joinedDF.show()

  }
}
