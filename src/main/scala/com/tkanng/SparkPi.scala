package com.tkanng


import com.tkanng.helloworld.HelloWorld
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

import scala.math.random


/** Computes an approximation to pi */
object SparkPi {
  def main(args: Array[String]) {
    var a = 0
    while (true) {
      a = a +1
      println(s"a:$a")
      Thread.sleep(1000)
    }
  }
}