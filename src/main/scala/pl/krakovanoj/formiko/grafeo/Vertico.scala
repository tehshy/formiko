package pl.krakovanoj.formiko.grafeo

import akka.actor.{Props, Actor}
import pl.krakovanoj.formiko.grafeo.meta.VerticaId
import scala.collection.mutable

class Vertico(id: VerticaId) extends Actor {

  /** Vertico enlistigas ĉiujn eĝojn ligitajn kun ĝi
    */
  val eĝoj: mutable.LinkedList[Eĝo] = collection.mutable.LinkedList[Eĝo]()



  def receive: Actor.Receive = ???
}

object Vertico {

  def props(id: VerticaId): Props = Props(new Vertico(id))

}