package shop.domain.model

import java.util.UUID

class UserId(id: UUID) {
  override def toString: String = {
    id.toString
  }

  def id(): UUID = {
    id
  }

  override def equals(obj: scala.Any): Boolean = {
    if (!obj.isInstanceOf[UserId]) {
      return false
    }
    id.equals(obj.asInstanceOf[UserId].id)
  }
}
