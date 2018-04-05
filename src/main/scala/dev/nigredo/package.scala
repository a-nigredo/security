package dev

import cats.data.EitherT
import cats.effect.IO
import dev.nigredo.error.Err

package object nigredo {
  type Result[A] = EitherT[IO, Err, A]
}
