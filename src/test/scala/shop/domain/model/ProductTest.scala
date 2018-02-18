package shop.domain.model

import org.scalatest.FunSpec

class ProductTest extends FunSpec {

  describe("Product") {
    it("has a name and a price") {
      val product = new Product("Chocolate", 1.99)
      assert(product.name == "Chocolate")
      assert(product.price == 1.99)
    }

    describe("equals") {
      it("returns true for product with same name and price") {
        val product1 = new Product("Chocolate", 1.99)
        val product2 = new Product("Chocolate", 1.99)

        assert(product1.equals(product2))
      }
    }
  }
}
