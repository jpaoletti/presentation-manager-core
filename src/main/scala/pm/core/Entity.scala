package pm.core

import collection.immutable._


/**
 * An entity is a visual representation of a class from your data model
 */
class Entity(id: String, clazz: String, extend: Entity ,fields: List[Field]) {
  private val allFields = {
    if(extend != null)
      (fields ::: extend.getFields.map(field => field.clone)).removeDuplicates
    else
      fields
  }
  allFields.foreach(field => field.entity = this)
  
  override def toString = id + "(" + clazz + ")"

  // Equality definition
  override def hashCode = 20 * id.hashCode
  override def equals(other: Any) = other match{
    case that: Entity => this.id == that.getId
    case _ => false
  }
  //Standar Java getters
  def getId = id
  def getClazz = clazz
  def getFields: List[Field] = allFields
}
