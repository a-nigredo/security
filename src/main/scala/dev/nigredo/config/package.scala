package dev.nigredo

package object config {
  type Config[A] = Unit => Result[A]
}
