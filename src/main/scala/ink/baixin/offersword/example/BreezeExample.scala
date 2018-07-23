package ink.baixin.offersword.example

import breeze.linalg._

object BreezeExample extends App {
  // Dense vector will allocate memory for zeros, where sparse won't.
  val x = DenseVector.zeros[Double](5)
  val y = SparseVector.zeros[Double](5)

  println(x) // DenseVector(0.0, 0.0, 0.0, 0.0, 0.0)
  println(y) // SparseVector(5)()

  // Access and update data elements by their index
  // and negative indices are supported, x(i) == x(x.length + i)
  println(x(0)) // 0.0
  x(4) = 4
  println(x(-1)) // 4.0

  x(3 to 4) := .5
  x(0 to 1) := DenseVector(.1, .2)
  println(x) // DenseVector(0.1, 0.2, 0.0, 0.5, 0.5)

  val m = DenseMatrix.zeros[Int](5, 5)
  println(m)

  // The columns of m can be accessed as DenseVectors, and the rows as DenseMatrices.
  val size = (m.rows, m.cols)
  println(size) // (5,5)

  val column = m(::, 1)
  println(column) // DenseVector(0, 0, 0, 0, 0)

  // Transpose to match row shape
  m(4, ::) := DenseVector(1, 2, 3, 4, 5).t
  println(m)

  m(0 to 1, 0 to 1) := DenseMatrix((3, 1), (-1, -2))
  println(m)
}
