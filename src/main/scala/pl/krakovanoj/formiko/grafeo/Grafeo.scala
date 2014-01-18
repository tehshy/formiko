package pl.krakovanoj.formiko.grafeo

import akka.actor.Actor
import pl.krakovanoj.formiko.grafeo.meta.{VerticaId, MetaGrafeo}

class Grafeo(strukturo: MetaGrafeo) extends Actor {

  val verticoj: Map[VerticaId, Vertico] = {
    strukturo.verticoj.map { vertico =>

      ???
    }
    ???
  }

  def receive: Actor.Receive = ???
}
