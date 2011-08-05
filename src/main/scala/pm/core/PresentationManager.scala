package pm.core

import pm.core.security._
import collection.mutable.Map

/**
 * Main class that contains the full definition of entites, sessions and
 * parameters
 * 
 */
class PresentationManager(params: Map[String, Any]) {
  val entities = Map.empty[String,Entity]
  val sessions = Map.empty[String,Session]

  def addEntity  (e:Entity)  = entities + ( e.getId -> e )
  def addSession (s:Session) = sessions + ( s.getId -> s )
}
