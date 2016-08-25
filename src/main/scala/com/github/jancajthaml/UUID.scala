package com.github.jancajthaml

/**
  * Helpers without uneccessary roundtrips
  *
  * @author jan.cajthaml
  */
private[jancajthaml] object x {

  import java.security.SecureRandom

  val seeder = new SecureRandom()
  val asHex = Array.tabulate(256)(i => Integer.toHexString(0x100 | i).substring(1))

}

/**
  * Faster compilant implementation of uuid4
  *
  * @author jan.cajthaml
  */
object uuid extends (() => String) {

  import x.{seeder, asHex}

  def apply(): String = {
    val seed:Array[Byte] = new Array[Byte](16)

    x.seeder.nextBytes(seed)
    x.asHex(seed(0) & 0xff) +
    x.asHex(seed(1) & 0xff) +
    x.asHex(seed(2) & 0xff) +
    x.asHex(seed(3) & 0xff) +
    '-' +
    x.asHex(seed(4) & 0xff) +
    x.asHex(seed(5) & 0xff) +
    '-' +
    x.asHex(((seed(6) & 0x0f) | 0x40) & 0xff) +
    x.asHex(seed(7) & 0xff) +
    '-' +
    x.asHex(((seed(8) & 0x3f) | 0x80) & 0xff) +
    x.asHex(seed(9) & 0xff) +
    '-' +
    x.asHex(seed(10) & 0xff) +
    x.asHex(seed(11) & 0xff) +
    x.asHex(seed(12) & 0xff) +
    x.asHex(seed(13) & 0xff) +
    x.asHex(seed(14) & 0xff) +
    x.asHex(seed(15) & 0xff)
  }

}
