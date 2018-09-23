package ink.baixin.offersword.problem

object Problem16 {
  case class ListNode(value: Int, var next: ListNode)

  def reverseList(head: ListNode): ListNode = {
    var current = head
    var reversedHead: ListNode = null
    var prev: ListNode = null

    while (current != null) {
      // first save the next
      val next = current.next
      if (next == null) {
        reversedHead = current
      }
      // then change pointer to prev
      current.next = prev
      // store current to prev
      prev = current
      // finally set next to current
      current = next

    }
    return reversedHead
  }

  def main(args: Array[String]): Unit = {
    val normalNode = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, null)))))
    val oneNode = ListNode(1, null)
    val nullNode = null
    println(reverseList(normalNode))
    println(reverseList(oneNode))
    println(reverseList(nullNode))
  }
}