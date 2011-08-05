package pm.core

class Field(id: String) {
  var entity: Entity = null
  var property: String = id
  
  override def toString = entity.getId + "." + id


  override def clone = new Field(id)
  // Equality definition
  override def hashCode = 21 * id.hashCode
  override def equals(other: Any) = other match{
    case that: Field => this.id == that.getId && that.entity == this.entity
    case _ => false
  }

  //Standar Java getters
  def getId = id
  def getProperty = if(property == null) id else property
}
