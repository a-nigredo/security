package dev.nigredo.modules

import com.softwaremill.macwire._
import dev.nigredo.controller.{Controller, SubjectController}

@Module
class ControllerModule(private val repoModule: RepositoryModule) {
  lazy val subjectController: SubjectController = wire[SubjectController]
  lazy val services: Set[Controller] = wireSet[Controller]
}
