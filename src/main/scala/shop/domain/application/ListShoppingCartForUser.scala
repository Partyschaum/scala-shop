package shop.domain.application

import java.util.UUID

import shop.domain.model.{CartRepository, UserId}

class ListShoppingCartForUser(cartRepository: CartRepository) {

  def execute(request: ListShoppingCartForUserRequest): ListShoppingCartForUserResponse = {
    val userId = new UserId(UUID.fromString(request.userId))
    val cart = cartRepository.findByUserId(userId)
    val products = cart.items().map(i => (i.name, i.price))
    new ListShoppingCartForUserResponse(products)
  }
}
