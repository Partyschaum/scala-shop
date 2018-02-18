package shop.domain.model

trait CartRepository {
  def add(cart: Cart): Unit

  def remove(cart: Cart): Unit

  def all(): List[Cart]

  def findByUserId(userId: UserId): Cart
}
