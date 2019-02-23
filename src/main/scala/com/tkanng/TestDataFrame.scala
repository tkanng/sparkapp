package com.tkanng

import org.apache.spark.sql.SparkSession

object TestDataFrame{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().getOrCreate()
    val df = spark.read.json("src/main/resources/people.json")
    df.show()
    val ds = df.toDF("name")
    case class People()
  }
}
