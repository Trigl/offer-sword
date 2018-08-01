package ink.baixin.offersword.problem

import scala.collection.mutable.ArrayBuffer

object Problem03 {
  def isExist(arr: Array[Array[Int]], n: Int): Boolean = {
    if (!arr.isEmpty) {
      if (n < arr(arr.length - 1)(0)) {
        isExist(arr.dropRight(1), n)
      } else if (n > arr(arr.length - 1)(0)) {
        val arrVar = ArrayBuffer[Array[Int]]()
        if (arr(0).length > 1) {
          for (i <- 0 until arr.length) {
            arrVar += arr(i).drop(1)
          }
        }
        isExist(arrVar.toArray, n)
      } else {
        true
      }
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(Array(1, 2, 4, 6), Array(2, 4, 7, 8), Array(8, 9, 10, 11), Array(9, 12, 13, 15))
    println("Is 0 existing in arr: " + isExist(arr, 0))
    println("Is 3 existing in arr: " + isExist(arr, 3))
    println("Is 7 existing in arr: " + isExist(arr, 7))
    println("Is 15 existing in arr: " + isExist(arr, 16))
  }
}
