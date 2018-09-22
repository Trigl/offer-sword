package ink.baixin.offersword.problem

object Problem12 {
  def print1ToMaxOfNDigits(n: Int) = {
    if (n <= 0) {
      throw new RuntimeException("The input number must be larger than 0!")
    }
    // create a array with fixed length and default value
    val arr = Array.fill(n)('0')
    while (!increment(arr)) {
      printNumber(arr)
    }
  }

  def increment(arr: Array[Char]): Boolean = {
    // mark if reaching the max number
    var isOverflow = false
    // mark if carry, 0 as false while 1 as true
    var isCarry = 0
    val length = arr.length

    for (i <- length - 1 to 0 by -1) {
      var sum = arr(i) - '0' + isCarry
      // add 1 if at the last
      if (i == length - 1) {
        sum = sum + 1
      }

      if (sum > 9) {
        // reach the max
        if (i == 0) {
          isOverflow = true
        } else {
          // if sum is beyond 9, set isCarry to 1
          sum = sum - 10
          isCarry = 1
          arr(i) = (sum + '0').toChar
        }
      } else {
        arr(i) = (sum + '0').toChar
        return isOverflow
      }
    }
    isOverflow
  }

  def printNumber(arr: Array[Char]) = {
    var isBeginning0 = true

    for (ch <- arr) {
      if (isBeginning0 && ch != '0') {
        isBeginning0 = false
      }
      if (!isBeginning0) {
        print(ch)
      }
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    print1ToMaxOfNDigits(3)
  }
}