package shop.domain.model

import java.util.UUID

import org.scalatest.FunSpec

class CartTest extends FunSpec {

  describe("Cart") {
    describe("when initially created") {
      it("contains no items") {
        val cart = new Cart(new UserId(UUID.randomUUID()))
        assert(cart.items().isEmpty)
      }
    }

    describe("after adding two items") {
      it("contains two items") {
        val cart = new Cart(new UserId(UUID.randomUUID()))
        cart.addItem(new Item("Chocolate", 1.99))
        cart.addItem(new Item("Peanuts", 2.49))
        assert(cart.items().lengthCompare(2) == 0)
      }
    }
  }
}
