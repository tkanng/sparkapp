package com.tkanng


import org.apache.spark.sql.SparkSession

object TestNarrowAndShuffleDep{

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .appName("Spark Pi")
      .getOrCreate()
    val sc = spark.sparkContext
     val pairRdd = sc.parallelize(List(("cat",2),("cat",5),("mouse",4),("cat",12),("dog",12),("mouse",2)),2).groupByKey()
//    pairRdd.aggregateByKey(100)(math.max(_ , _),  _ + _ ).collect

    Thread.sleep(1000000)
    spark.stop()

  }
}