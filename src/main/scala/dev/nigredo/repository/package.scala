package dev.nigredo

import cats.effect.IO

package object repository {
  type FindAll[A] = Unit => IO[List[A]]
  type FindOneById[A] = Long => IO[Option[A]]
  type Insert[A, B] = A => IO[B]
}
