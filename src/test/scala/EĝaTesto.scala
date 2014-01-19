import akka.actor.{ActorSystem, Props}
import org.scalatest.FlatSpec
import pl.pej.formiko.grafeo.{Eĝo, Vertico, Grafeo}
import pl.pej.formiko.grafeo.meta._
import pl.pej.formiko.grafeo.meta.MetaGrafeo
import pl.pej.formiko.grafeo.meta.MetaVertico
import pl.pej.formiko.grafeo.meta.Pozicio
import pl.pej.formiko.grafeo.meta.VerticaId

class EĝaTesto extends FlatSpec {

  implicit def int2id(i: Int) = VerticaId(i)

//  val meta = MetaGrafeo(List(
//    MetaVertico(1, Pozicio(0,0)),
//    MetaVertico(2, Pozicio(2,2))
//  ),List(
//    MetaEĝo(1,2)
//  ))

  implicit val sistemo = ActorSystem("testa-sistemo")

  val (propsA, propsB) = (Vertico.props(1), Vertico.props(2))

  val (verticoA, verticoB) = {
    import sistemo._
    (actorOf(propsA), actorOf(propsB))
  }
  val eĝo = sistemo.actorOf(Eĝo.props(4))

  "La eĝo" should "respondi al demandoj pri feromonoj" ignore {

  }

  it should "ebligi la formikon vojaĝi de A al B" in {

  }

  it should "ebligi la formikon vojaĝi de unu vertico al la alia lasante iom da feromonaĵo" ignore {

  }


}
