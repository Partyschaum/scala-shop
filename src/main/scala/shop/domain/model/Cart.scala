package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart(val userId: UserId) {
  private val itemList: ListBuffer[Product] = ListBuffer[Product]()

  def items(): List[Product] = {
    this.itemList.toList
  }

  def addItem(item: Product): Unit = {
    this.itemList += item
  }
}
