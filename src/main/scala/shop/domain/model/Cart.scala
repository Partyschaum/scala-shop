package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart(userId: UserId) {
  private val itemList: ListBuffer[Item] = ListBuffer[Item]()

  def userId(): UserId = userId

  def items(): List[Item] = {
    this.itemList.toList
  }

  def addItem(item: Item): Unit = {
    this.itemList += item
  }
}
