package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.avg
//Problem:
//  You have two DataFrames: books and authors. Join them to find the books written by each author.
object Q_08_Book_Author_Publication {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_08_Book_Author_Publication")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Books DataFrame
    val books = Seq(
      ("B001", "Book One", "A001"),
      ("B002", "Book Two", "A002"),
      ("B003", "Book Three", "A001"),
      ("B004", "Book Four", "A003")
    ).toDF("book_id", "book_title", "author_id")

    // Authors DataFrame
    val authors = Seq(
      ("A001", "Author One"),
      ("A002", "Author Two"),
      ("A003", "Author Three")
    ).toDF("author_id", "author_name")

    val condition1 = authors("author_id") === books("author_id")

    val joinType = "inner"



    val joinedDF = authors
      .join(books, condition1, joinType)
      .drop(books("author_id"))

    joinedDF.show()
  }
}
