package pl.pej.formiko.grafeo

import akka.actor.{Props, ActorRef, Actor}
import pl.pej.formiko.grafeo.meta.{Disigu, DisiguVerticon, KuniguVerticon, VerticaId}

class Eĝo(val longeco: Int) extends Actor {

  val ligoj = collection.mutable.ListMap[VerticaId, ActorRef]()

  def receive: Actor.Receive = {

    case KuniguVerticon(idA, refA, idB, refB) =>
      ligoj.+=((idA, refA))
      ligoj.+=((idB, refB))
      context.become(ligita)

    case msĝ => throw new IllegalStateException("Neligita eĝo recivis la mesaĝon: " + msĝ)
  }

  def ligita: Receive = {

    case d@Disigu(id) =>
      ligoj.-=(id)
      assert(ligoj.size == 1)
      ligoj.head._2 ! d
      ligoj.clear()
      context.become(receive)

  }
}

object Eĝo {
  def props(longeco: Int): Props = Props(new Eĝo(longeco))
}