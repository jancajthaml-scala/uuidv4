package com.github.jancajthaml

import org.scalatest.{FlatSpec, Matchers}

class UUIDSpecs extends FlatSpec with Matchers {

  "uuid" should "render guid" in {
    val id = uuid()

    id should fullyMatch regex """[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"""
  }

  it should "have normal distribution" in {
    val arr = new Array[Int](601)
    def fn = (BigInt.apply(uuid() replaceAll ("[-]", ""), 16) % 601).toInt

    (0 to 10000).foreach { i => {
      val res = Math.abs(fn)
      arr(res) = (arr(res) + 1)
    } }

    val list = arr.toList

    list.min should be <= (10)
    list.max should be <= (50)
  }

}