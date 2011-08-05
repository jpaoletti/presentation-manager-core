package pm.core.security

class Permission (id:String){
  var description:String = ""
  
  // Equality definition
  override def hashCode = 23 * id.hashCode
  override def equals(other: Any) = other match{
    case that: Permission => this.id == that.getId
    case _ => false
  }
  //Standar Java getters
  def getId = id
  def getDescription = description
}
