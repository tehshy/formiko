package pl.pej.formiko.grafeo

import akka.actor.{Props, ActorRef, Actor}
import pl.pej.formiko.grafeo.meta.{VerticaId, MetaGrafeo}

class Grafeo(strukturo: MetaGrafeo) extends Actor {

  val verticoj: Map[VerticaId, ActorRef] = {
    strukturo.verticoj.map { meta =>
      (meta.id, context.actorOf(Vertico.props(meta.id), meta.id.toString))
    }.toMap
  }

  val mapo = strukturo.verticoj.map { meta =>
    (meta.id, meta.poz)
  }.toMap


  val eĝoj: collection.mutable.HashMap[(VerticaId, VerticaId), Eĝo] = {

    
  }


  def receive: Actor.Receive = ???
}

object Grafeo {
  def props(meta: MetaGrafeo): Props = Props(new Grafeo(meta))
}