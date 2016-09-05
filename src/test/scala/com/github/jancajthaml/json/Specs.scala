package com.github.jancajthaml

import collection.mutable.Stack
import org.scalatest._

class UUIDSpecs extends FlatSpec with Matchers {

  "uuid" should "render guid" in {
    val id = uuid()

    //json should startWith ("{")
    //json should endWith ("}")

    id should include ("-")
  }

}