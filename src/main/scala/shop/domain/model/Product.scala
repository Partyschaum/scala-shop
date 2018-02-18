package shop.domain.model

class Product(val name: String, val price: Double) {
  override def equals(obj: scala.Any): Boolean = {
    if (!obj.isInstanceOf[Product]) {
      return false
    }
    val aProduct = obj.asInstanceOf[Product]
    aProduct.name == name && aProduct.price == price
  }
}
