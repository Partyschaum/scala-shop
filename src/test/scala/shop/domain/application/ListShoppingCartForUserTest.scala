package shop.domain.application

import java.util.UUID

import org.scalatest.FunSpec
import shop.infrastructure.model.CartInMemoryRepository
import shop.domain.model.{Cart, Product, UserId}

import scala.collection.mutable.ListBuffer

class ListShoppingCartForUserTest extends FunSpec {

  it("lists all products from the user's shopping cart") {
    val userId = UUID.randomUUID()

    val product1 = new Product("Apple", 0.25)
    val product2 = new Product("Pear", 0.45)

    val cart = new Cart(new UserId(userId))
    cart.addItem(product1)
    cart.addItem(product2)

    val carts = ListBuffer[Cart](cart)

    val repository = new CartInMemoryRepository(carts)

    val useCase = new ListShoppingCartForUser(repository)
    val request = new ListShoppingCartForUserRequest(userId.toString)

    val response = useCase.execute(request)

    assert(response.products.lengthCompare(2) == 0)
    assert(response.products.contains(("Apple", 0.25)))
    assert(response.products.contains(("Pear", 0.45)))
  }
}
