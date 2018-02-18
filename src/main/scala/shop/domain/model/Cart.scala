package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart(userId: UserId) {
  private val itemList: ListBuffer[Product] = ListBuffer[Product]()

  def userId(): UserId = userId

  def items(): List[Product] = {
    this.itemList.toList
  }

  def addItem(item: Product): Unit = {
    this.itemList += item
  }
}
