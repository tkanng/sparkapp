package com.tkanng

import scala.collection.mutable.ArrayBuffer


case class Person(name: String, age: Int)


object Hello {

  def hello():String={
    "Hello"
  }

  def main(args: Array[String]): Unit = {

    val a = Person("a", 11)
    val b = Person("b", 11)

    implicit object PersonOrdering extends Ordering[Person] {
      override def compare(p1: Person, p2: Person): Int = {
        p1.name == p2.name match {
          case false => -p1.name.compareTo(p2.name)
          case _ => p1.age - p2.age
        }
      }
    }
    import Ordered._

    print(a < b)

    val left = List(1, 2, 3)
    val right = List(4, 5, 6)
    //以下操作等价
    println(left ++ right) // List(1,2,3,4,5,6)
    println(left ++: right) // List(1,2,3,4,5,6)
    println(right.++:(left)) // List(1,2,3,4,5,6)
    println(right.:::(left)) // List(1,2,3,4,5,6)

    //以下操作等价
    println(0 +: left) //List(0,1,2,3)
    println(left.+:(0)) //List(0,1,2,3)
    //以下操作等价
    println(left :+ 4) //List(1,2,3,4)
    println(left.:+(4)) //List(1,2,3,4)

    //以下操作等价
    println(0 :: left) //List(0,1,2,3)
    println(left.::(0)) //List(0,1,2,3)


    val t = ("hello", 1, 2.3)
    println(t.toString())

    val res = List[(Int, ArrayBuffer[(Int, Int)])]()
    val s = res match {
      case Nil => "Nil"
      case head :: rest => "Not Nil"
    }
    println(s)


  }

  def groupSorted[K, S, V](it: Iterator[((K, S), V)]): Iterator[(K, List[(S, V)])] = {
    val res = List[(K, ArrayBuffer[(S, V)])]()
    val a = it.foldLeft(res)((list, next) => list match {
      case Nil =>
        val ((firstKey, secondKey), value) = next
        List((firstKey, ArrayBuffer((secondKey, value))))
      case head :: rest =>
        val (curKey, valueBuf) = head
        val ((firstKey, secondKey), value) = next
        if (!firstKey.equals(curKey)) {
          (firstKey, ArrayBuffer((secondKey, value))) :: list
        } else {
          valueBuf.append((secondKey, value))
          list
        }
    }).map { case (key, buf) => (key, buf.toList) }
    a.iterator
  }
}