package com.github.jancajthaml

import org.scalatest.{FlatSpec, Matchers}

class UUIDSpecs extends FlatSpec with Matchers {

  "uuid" should "render guid" in {
    val id = uuid()

    id should fullyMatch regex """[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"""
  }

  it should "should have low gaps" in {
    val arr = new Array[Int](601)
    def fn = (BigInt.apply(uuid() replaceAll ("[-]", ""), 16) % 601).toInt

    var it = 0
    while (it < 10000) {
      val res = Math.abs(fn)
      arr(res) = (arr(res) + 1)
      it = it + 1
    }
    val list = arr.toList

    list.min should be <= (10)
    list.max should be <= (50)
  }

}