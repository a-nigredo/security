package dev.nigredo.controller

import cats.effect._
import dev.nigredo.error.{ConfigErr, NotFoundErr}
import dev.nigredo.modules.RepositoryModule
import org.http4s._
import org.http4s.dsl.io._

class SubjectController(private val repositoryModule: RepositoryModule) extends Controller {
  override def apply(v1: Unit): HttpService[IO] = HttpService[IO] {
    case GET -> Root / "subject" => repositoryModule.findAllSubject.fold({
      case ConfigErr(msg) => InternalServerError(msg.mkString(","))
      case NotFoundErr(_) => NotFound()
    }, r => r().flatMap(x => Ok(x.mkString(",")))).unsafeRunSync()
  }
}
