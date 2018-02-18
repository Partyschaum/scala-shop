package shop.infrastructure.model

import shop.domain.model.{Cart, CartRepository}

import scala.collection.mutable.ListBuffer

class CartInMemoryRepository(storage: ListBuffer[Cart]) extends CartRepository{

  override def add(cart: Cart): Unit = {
    storage += cart
  }

  override def remove(cart: Cart): Unit = {
    storage -= cart
  }

  override def all(): List[Cart] = {
    storage.toList
  }
}
