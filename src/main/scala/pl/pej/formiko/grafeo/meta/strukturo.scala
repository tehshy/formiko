package pl.pej.formiko.grafeo.meta

/** Strukturoj priskribantaj grafeojn.
  */
case class MetaGrafeo(verticoj: List[MetaVertico], eĝoj: List[MetaEĝo])

case class VerticaId(id: Int) extends AnyVal
case class Pozicio(x: Int, y: Int)

case class MetaVertico(id: VerticaId, poz: Pozicio)
case class MetaEĝo(de: VerticaId, al: VerticaId)