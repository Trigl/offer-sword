package ink.baixin.offersword.problem

object Problem11 {
  def power(base: Double, exponent: Int): Double = {
    val n = Math.abs(exponent)
    if (exponent == 0) return 1
    if (exponent == 1) return base

    var result = power(base, n >> 1)
    result = result * result

    if ((exponent & 1) == 1) result = result * base

    if (exponent < 0)
      if (base == 0) throw new RuntimeException("Base can't be zero when exponent is minus!")
      else result = 1 / result

    result
  }

  def main(args: Array[String]): Unit = {
    println(power(3.3, 3))
    println(power(-3.3, 3))
    println(power(3.3, -3))
    println(power(-3.3, -3))
    println(power(3.3, 0))
    println(power(0, 0))
    println(power(0, -3))
  }
}
