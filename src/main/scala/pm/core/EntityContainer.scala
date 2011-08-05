package pm.core


/**
 * This is a per-session entity definition with the current state of the
 * visualization of the represented entity
 */
class EntityContainer(entity: Entity) {

  // Equality definition
  override def hashCode = 30 * entity.hashCode
  override def equals(other: Any) = other match{
    case that: EntityContainer => entity == that.getEntity
    case _ => false
  }
  //Standar Java getters
  def getEntity = entity
}
