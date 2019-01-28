package com.tkanng

import org.scalatest.{BeforeAndAfter, FunSuite, PrivateMethodTester}

class  HelloSuite extends FunSuite{
    test("An empty Set should have size 0") {
    assert(Set.empty.isEmpty)
  }

}