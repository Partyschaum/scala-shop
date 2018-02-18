package shop.domain.model

import org.scalatest.FunSpec

class CartItemTest extends FunSpec {

  it("contains a product and an amount") {
    val product = new Product("Shaving Cream", 3.29)
    val item = new CartItem(product, 3)
    assert(item.product.equals(product))
    assert(item.amount.equals(3))
  }
}
