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

    describe("after adding six products") {
      it("contains six products") {
        val cart = fixture.aCart
        cart.addItem(new Product("Nutella", 2.99))
        cart.addItem(new Product("Chocolate", 1.99), 3)
        cart.addItem(new Product("Peanuts", 2.49), 2)
        assert(cart.items().lengthCompare(6) == 0)
      }
    }

    describe("remove product from cart") {
      it("removes specified product") {
        val cart = fixture.aCart
        cart.addItem(new Product("Nutella", 2.99), 2)
        cart.addItem(new Product("Chocolate", 1.99), 3)
        cart.removeItem(new Product("Nutella", 2.99))
        assert(cart.items().lengthCompare(4) == 0)
      }

      describe("product not in cart") {
        it("throws exception ") {
          val cart = fixture.aCart
          assertThrows[NoSuchElementException] {
            cart.removeItem(new Product("Unavailable Product", 0.99))
          }
        }
      }
    }
  }
}
