package dev.nigredo.error

sealed trait Err

case class NotFoundErr(msg: String) extends Err
case class ConfigErr(errs: List[String]) extends Err
