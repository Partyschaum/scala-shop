package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart(val userId: UserId) {
  private val itemList: ListBuffer[CartItem] = ListBuffer[CartItem]()

  def items(): List[CartItem] = {
    this.itemList.toList
  }

  def addItem(product: Product, amount: Int): Unit = {
    this.itemList += new CartItem(product, amount)
  }
}
