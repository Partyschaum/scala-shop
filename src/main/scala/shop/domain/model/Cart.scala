package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart {
  private val itemList: ListBuffer[Item] = ListBuffer[Item]()

  def items(): List[Item] = {
    this.itemList.toList
  }

  def addItem(item: Item): Unit = {
    this.itemList += item
  }
}
