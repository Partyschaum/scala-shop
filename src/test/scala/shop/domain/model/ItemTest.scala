package shop.domain.model

import org.scalatest.FunSpec

class ItemTest extends FunSpec {

  describe("Item") {
    it("has a name and a price") {
      val item = new Item("Chocolate", 1.99)
      assert(item.name() == "Chocolate")
      assert(item.price() == 1.99)
    }
  }
}
