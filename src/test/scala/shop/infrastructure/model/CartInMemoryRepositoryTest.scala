package shop.infrastructure.model

import java.util.UUID

import org.scalatest.FunSpec
import shop.domain.model.{Cart, Product, UserId}

import scala.collection.mutable.ListBuffer

class CartInMemoryRepositoryTest extends FunSpec {

  describe("CartInMemoryRepository") {

    describe("uses passed in ListBuffer as storage") {
      it("contains Carts from passed in ListBuffer") {
        val storage = new ListBuffer[Cart]

        val cart1 = new Cart(new UserId(UUID.randomUUID()))
        val cart2 = new Cart(new UserId(UUID.randomUUID()))

        storage += cart1
        storage += cart2

        val repository = new CartInMemoryRepository(storage)

        assert(repository.all().contains(cart1))
        assert(repository.all().contains(cart2))
      }
    }

    describe("contains no Carts") {
      it("returns empty list") {
        val repository = new CartInMemoryRepository(ListBuffer[Cart]())

        assert(repository.all().lengthCompare(0) == 0)
      }
    }

    describe("contains Carts") {
      it("returns list of Carts") {
        val repository = new CartInMemoryRepository(ListBuffer[Cart]())
        val cart1 = new Cart(new UserId(UUID.randomUUID()))
        val cart2 = new Cart(new UserId(UUID.randomUUID()))

        repository.add(cart1)
        repository.add(cart2)

        assert(repository.all().contains(cart1))
        assert(repository.all().contains(cart2))
      }
    }

    describe("removes Carts") {
      it("removes a Cart") {
        val repository = new CartInMemoryRepository(ListBuffer[Cart]())
        val cart1 = new Cart(new UserId(UUID.randomUUID()))
        val cart2 = new Cart(new UserId(UUID.randomUUID()))

        repository.add(cart1)
        repository.add(cart2)

        repository.remove(cart1)
        assert(!repository.all().contains(cart1))

        repository.remove(cart2)
        assert(!repository.all().contains(cart2))
      }
    }

    it("finds a User's Cart") {
      val repository = new CartInMemoryRepository(ListBuffer[Cart]())
      val userId = new UserId(UUID.randomUUID())
      val cart = new Cart(userId)

      repository.add(cart)

      assert(repository.findByUserId(userId).equals(cart))
    }
  }
}
