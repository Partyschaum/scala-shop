package shop.domain.model

import scala.collection.mutable.ListBuffer

class Cart(val userId: UserId) {
  private val itemList: ListBuffer[Product] = ListBuffer[Product]()

  def items(): List[Product] = {
    this.itemList.toList
  }

  def addItem(product: Product, amount: Int = 1): Unit = {
    for (_ <- 1 until amount + 1) {
      this.itemList += product
    }
  }

  def removeItem(product: Product): Unit = {
    for (i <- this.itemList) {
      if (i.equals(product)) {
        this.itemList -= product
        return
      }
    }
    throw new NoSuchElementException(s"Product ${product.name} is not in cart!")
  }
}
