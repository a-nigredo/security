package dev.nigredo.config

import cats.data.EitherT
import cats.effect.IO
import dev.nigredo.Result
import dev.nigredo.config.model.Db
import dev.nigredo.error.ConfigErr
import extruder.core.ValidationErrors
import extruder.typesafe.TypesafeConfigSource.decode
import extruder.refined._
import cats.implicits._

class DbConfig extends Config[Db] {

  private type EitherTIO[A] = EitherT[IO, ValidationErrors, A]

  override def apply(v1: Unit): Result[Db] = decode[Db, EitherTIO].leftMap(x => ConfigErr(x.toList.map(_.message)))
}
