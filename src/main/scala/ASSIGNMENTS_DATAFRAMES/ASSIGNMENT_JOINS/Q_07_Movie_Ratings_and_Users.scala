package ASSIGNMENTS_DATAFRAMES.ASSIGNMENT_JOINS

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.avg
//Problem:
//  You have three DataFrames: movies, users, and ratings. Join them to find the average rating for each
//  movie.
object Q_07_Movie_Ratings_and_Users {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.set("spark.app.name", "Q_07_Movie_Ratings_and_Users")
    conf.set("spark.master", "local[4]")

    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    import spark.implicits._

    // Movies DataFrame
    val movies = Seq(
      ("M001", "Inception"),
      ("M002", "The Dark Knight"),
      ("M003", "Interstellar"),
      ("M004", "Titanic")
    ).toDF("movie_id", "movie_title")

    // Users DataFrame
    val users = Seq(
      ("U001", "Alice"),
      ("U002", "Bob"),
      ("U003", "Charlie")
    ).toDF("user_id", "user_name")

    // Ratings DataFrame
    val ratings = Seq(
      ("R001", "M001", "U001", 5),
      ("R002", "M002", "U001", 4),
      ("R003", "M003", "U002", 5),
      ("R004", "M002", "U003", 3),
      ("R005", "M001", "U002", 4),
      ("R006", "M004", "U001", 2)
    ).toDF("rating_id", "movie_id", "user_id", "rating")

    val condition1 = movies("movie_id") === ratings("movie_id")
    val condition2 = ratings("user_id") === users("user_id")

    val joinType = "inner"

    val joinedDF = movies
      .join(ratings, condition1, joinType)
      .drop(ratings("movie_id"))
      .join(users, condition2,joinType)
      .drop(ratings("user_id")).
      groupBy("movie_title").agg(avg("rating"))

    joinedDF.show()
  }
}
