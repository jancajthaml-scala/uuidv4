package com.github.jancajthaml

/**
  * Helpers without uneccessary roundtrips
  *
  * @author jan.cajthaml
  */
private[jancajthaml] object x {

  import java.security.SecureRandom

  val random = new SecureRandom()
  val asHex = Array.tabulate(256)(i => Integer.toHexString(0x100 | i).substring(1))

}

/**
  * Generate 128bit UUID (Universally Unique IDentifier) with
  * cryptographically secure PRNG
  *
  * @see http://www.ietf.org/rfc/rfc4122.txt
  *
  * @author jan.cajthaml
  */
object uuid extends (() => String) {

  import x.{random, asHex}

  /**
   * @return uuid4
   */
  def apply(): String = {
    val byte:Array[Byte] = new Array[Byte](16)

    //saturate byte with random values
    x.random.nextBytes(byte)

    x.asHex(byte(0) & 0xff) +
    x.asHex(byte(1) & 0xff) +
    x.asHex(byte(2) & 0xff) +
    x.asHex(byte(3) & 0xff) +
    '-' +
    x.asHex(byte(4) & 0xff) +
    x.asHex(byte(5) & 0xff) +
    '-' +
    x.asHex(((byte(6) & 0x0f) | 0x40) & 0xff) +
    x.asHex(byte(7) & 0xff) +
    '-' +
    x.asHex(((byte(8) & 0x3f) | 0x80) & 0xff) +
    x.asHex(byte(9) & 0xff) +
    '-' +
    x.asHex(byte(10) & 0xff) +
    x.asHex(byte(11) & 0xff) +
    x.asHex(byte(12) & 0xff) +
    x.asHex(byte(13) & 0xff) +
    x.asHex(byte(14) & 0xff) +
    x.asHex(byte(15) & 0xff)
  }

}
