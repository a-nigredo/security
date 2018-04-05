package dev.nigredo.model.domain

import java.util.Date

sealed trait Subject {
  val creationDate: Date = new Date()
}

case class NewSubject(name: String) extends Subject

case class ExistingSubject(id: Long, name: String, override val creationDate: Date) extends Subject
