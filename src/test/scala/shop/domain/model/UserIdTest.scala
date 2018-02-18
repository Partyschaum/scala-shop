package shop.domain.model

import java.util.UUID

import org.scalatest.FunSpec

class UserIdTest extends FunSpec {

  describe("UserId") {

    it("returns UUID as string") {
      val uuid = UUID.randomUUID()
      val userId = new UserId(uuid)

      assert(userId.toString.equals(uuid.toString))
    }

    describe("equals") {
      it("returns true") {
        val uuid = UUID.randomUUID()
        val userId1 = new UserId(uuid)
        val userId2 = new UserId(uuid)

        assert(userId1.equals(userId2))
      }
    }
  }
}
