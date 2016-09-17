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
  var inc = scala.util.Random.nextInt()

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

  /**
   * @return uuid4
   */
  def apply(): String = {
    
    val byte:Array[Byte] = new Array[Byte](16)
    x.inc = x.inc + 1
    val time = (System.currentTimeMillis / 1000).asInstanceOf[Int]
    
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
    x.asHex(((byte(6) & 0x0f) | x.inc) & 0xff) +
    x.asHex(byte(7) & 0xff) +
    '-' +
    x.asHex(((byte(8) & 0x3f) | time) & 0xff) +
    x.asHex(byte(9) & 0xff) +
    '-' +
    x.asHex(byte(10) & 0xff) +
    x.asHex(byte(11) & 0xff) +
    x.asHex(byte(12) & 0xff) +
    x.asHex(byte(13) & 0xff) +
    x.asHex(byte(14) & 0xff) +
    x.asHex(byte(15) & 0xff)

    

    //val time = (System.currentTimeMillis / 1000)
    //println("time - " + time)
    //var MACHINE_ID = scala.util.Random.nextInt()
    //println("MACHINE_ID - " + MACHINE_ID)
    //var pid = (ProcessHandle.current().getPid() % 0xFFFF)
    //println("pid - " + pid)

    

    //println("inc - " + inc)

    //"XXX"
/*
    //(data, bits, signed, forceBigEndian)
    var time4Bytes = BinaryParser.encodeInt(time, 32, true, true)

    //println("MACHINE_ID" + MACHINE_ID)

    /* for time-based ObjectID the bytes following the time will be zeroed */
    var machine3Bytes = BinaryParser.encodeInt(MACHINE_ID, 24, false)
    var pid2Bytes = BinaryParser.fromShort(ProcessHandle.current().getPid() % 0xFFFF)
    

/*
    ObjectID.prototype.get_inc = function() {
      return ObjectID.index = (ObjectID.index + 1) % 0xFFFFFF;
    };
    */

    //var index3Bytes = BinaryParser.encodeInt(this.get_inc(), 24, false, true)
    var index3Bytes = BinaryParser.encodeInt(index, 24, false, true)

    time4Bytes + machine3Bytes + pid2Bytes + index3Bytes
    */

  }

}
