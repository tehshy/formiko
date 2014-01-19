package pl.pej.formiko.grafeo

import akka.actor.{ActorRef, Props, Actor}
import pl.pej.formiko.grafeo.meta.{Disigu, KuniguVerticon, VerticaId}
import scala.collection.mutable

class Vertico(id: VerticaId) extends Actor {

  /** Vertico enlistigas ĉiujn eĝojn ligitajn kun ĝi
    */
  val eĝoj: mutable.LinkedList[Eĝo] = collection.mutable.LinkedList[Eĝo]()


  val ligoj = collection.mutable.ListMap[VerticaId, ActorRef]()

  def receive: Actor.Receive = {

    case msĝ if ligoj.size == 1 =>
      throw new IllegalStateException("Neligita vertico recivis la mesaĝon: " + msĝ)

    case KuniguVerticon(id, ref) =>
      ligoj.+=((id, ref))

    case d@Disigu(id) =>
      ligoj.-=(id)

  }

}

object Vertico {

  def props(id: VerticaId): Props = Props(new Vertico(id))

}