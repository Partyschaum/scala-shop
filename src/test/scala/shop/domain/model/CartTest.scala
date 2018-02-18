package shop.domain.model

import java.util.UUID

import org.scalatest.FunSpec

class CartTest extends FunSpec {

  def fixture = new {
    val aCart = new Cart(new UserId(UUID.randomUUID()))
  }

  describe("Cart") {
    describe("when initially created") {
      it("contains no items") {
        val cart = fixture.aCart
        assert(cart.items().isEmpty)
      }
    }

    describe("after adding two items") {
      it("contains two items") {
        val cart = fixture.aCart
        cart.addItem(new Product("Chocolate", 1.99))
        cart.addItem(new Product("Peanuts", 2.49))
        assert(cart.items().lengthCompare(2) == 0)
      }
    }
  }
}
