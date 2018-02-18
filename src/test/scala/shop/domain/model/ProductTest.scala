package shop.domain.model

import org.scalatest.FunSpec

class ProductTest extends FunSpec {

  describe("Product") {
    it("has a name and a price") {
      val product = new Product("Chocolate", 1.99)
      assert(product.name == "Chocolate")
      assert(product.price == 1.99)
    }
  }
}
