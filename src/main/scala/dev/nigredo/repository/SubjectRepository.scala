package dev.nigredo.repository

import cats.effect.IO
import dev.nigredo.model.domain.{ExistingSubject, NewSubject, Subject}
import doobie._
import doobie.implicits._

object SubjectRepository {

  type TX = Transactor[IO]

  private final val table = fr"subject"
  private final val selectQuery = fr"select * from" ++ table

  class FindAllSubject(private val tx: TX) extends FindAll[Subject] {
    override def apply(v1: Unit): IO[List[Subject]] = selectQuery.query[ExistingSubject].to[List].transact(tx)
  }

  class FindSubjectById(private val tx: TX) extends FindOneById[Subject] {
    override def apply(id: Long): IO[Option[Subject]] =
      (selectQuery ++ fr"where id = $id").query[ExistingSubject].option.transact(tx)
  }

  class InsertSubject(private val tx: TX) extends Insert[NewSubject, ExistingSubject] {
    override def apply(subj: NewSubject): IO[ExistingSubject] = {
      (fr"insert into " ++ table ++ fr"(name, creationDate) values (${subj.name}, ${subj.creationDate})")
        .update
        .withUniqueGeneratedKeys[ExistingSubject]("id", "name", "creationDate")
        .transact(tx)
    }
  }

}
