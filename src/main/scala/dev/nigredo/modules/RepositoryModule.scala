package dev.nigredo.modules

import cats.data.EitherT
import cats.effect.IO
import com.softwaremill.macwire._
import dev.nigredo.Result
import dev.nigredo.config.DbConfig
import dev.nigredo.error.Err
import dev.nigredo.model.domain.Subject
import dev.nigredo.repository.{FindAll, SubjectRepository}
import doobie.util.transactor.Transactor

@Module
class RepositoryModule {

  private lazy val transactor: EitherT[IO, Err, SubjectRepository.TX] = wire[DbConfig]()
    .map(db => Transactor.fromDriverManager[IO](db.driver.value, db.url.value, db.user.value, db.password))

  lazy val findAllSubject: Result[FindAll[Subject]] =
    transactor.map(x => new SubjectRepository.FindAllSubject(x))
}