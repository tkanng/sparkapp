package com.tkanng

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FunSuite, PrivateMethodTester}
import Hello.hello
class  HelloSuite extends FunSuite with BeforeAndAfterAll{
  override def beforeAll(): Unit = {
    println("Before all")
    super.beforeAll()

  }
  test("Hello.hello method") {
      println("Test")
    assert(hello()=="Hello")
  }

  override def afterAll(): Unit = {
    println("After all")
    super.afterAll()
  }

}