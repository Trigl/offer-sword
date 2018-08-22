package ink.baixin.offersword.problem

import scala.collection.mutable.ArrayBuffer

object Problem04 {

  def replaceBlank(str: ArrayBuffer[Char]): String = {
    var (initLen, targetLen) = getLength(str)
    // extend the length of ArrayBuffer
    for (i <- initLen until targetLen) str += ' '

    while (initLen > 0 && targetLen > 0) {
      initLen -= 1
      val ch = str(initLen)
      if (ch == ' ') {
        targetLen -= 1
        str(targetLen) = '0'
        targetLen -= 1
        str(targetLen) = '2'
        targetLen -= 1
        str(targetLen) = '%'
      } else {
        targetLen -= 1
        str(targetLen) = ch
      }
    }

    str.toString()
  }

  def getLength(str: ArrayBuffer[Char]): (Int, Int) = {
    // initial string's length
    var initLength = 0
    // blank char's size
    var blankSize = 0

    for (ch <- str) {
      initLength += 1
      if (ch == ' ') blankSize += 1
    }
    (initLength, initLength + 2 * blankSize)
  }

  def main(args: Array[String]): Unit = {
    val str = ArrayBuffer[Char]('W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.')
    println(replaceBlank(str))
  }
}
