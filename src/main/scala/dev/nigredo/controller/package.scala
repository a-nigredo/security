package dev.nigredo

import cats.effect.IO
import org.http4s.HttpService

package object controller {
  type Controller = Unit => HttpService[IO]
}
