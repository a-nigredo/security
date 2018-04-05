package dev.nigredo

import cats.effect.IO
import fs2.StreamApp.ExitCode
import fs2.{Stream, StreamApp}
import org.http4s.server.blaze.BlazeBuilder
import cats.implicits._

import dev.nigredo.modules.{ControllerModule, RepositoryModule}
import scala.concurrent.ExecutionContext.Implicits.global
object App extends StreamApp[IO] {

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] = {
    val sv = new ControllerModule(new RepositoryModule).services
    BlazeBuilder[IO].bindHttp(8080, "localhost")
      .mountService(sv.foldLeft(sv.head(()))(_ <+> _ ()), "/").serve
  }
}
