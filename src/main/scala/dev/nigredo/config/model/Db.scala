package dev.nigredo.config.model

import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.NonEmpty

case class Db(driver: String Refined NonEmpty, url: String Refined NonEmpty, user: String Refined NonEmpty,
              password: String)
