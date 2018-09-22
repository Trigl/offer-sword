package ink.baixin.offersword.problem

object Problem13 {
  case class ListNode(var value: Int, var next: ListNode)

  def deleteNode(head: ListNode, toBeDeleted: ListNode): ListNode = {
    if (head == null || toBeDeleted == null) return null

    if (toBeDeleted.next != null) {
      // if toBeDeleted is not the last node
      toBeDeleted.value = toBeDeleted.next.value
      toBeDeleted.next = toBeDeleted.next.next
      head
    } else {
      if (head == toBeDeleted) {
        // if head node is the last node
        null
      } else {
        // traverse all nodes and delete the last
        var node = head
        while (node.next != toBeDeleted) {
          node = node.next
        }
        node.next = null
        head
      }
    }
  }
}