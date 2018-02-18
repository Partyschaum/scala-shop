package shop.domain.model

import java.util.UUID

class UserId(val id: UUID) {
  override def toString: String = {
    id.toString
  }

  override def equals(obj: scala.Any): Boolean = {
    if (!obj.isInstanceOf[UserId]) {
      return false
    }
    id.equals(obj.asInstanceOf[UserId].id)
  }
}
