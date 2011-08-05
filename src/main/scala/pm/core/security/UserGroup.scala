package pm.core.security

class UserGroup(id:String) {
  var name: String = ""
  var description: String = ""
  var active: Boolean = true
  var permissions: List[Permission] = Nil;

  def hasPermission (permission: String):Boolean = permissions.contains(new Permission(permission))
  def ? = hasPermission _

  // Equality definition
  override def hashCode = 26 * id.hashCode
  override def equals(other: Any) = other match{
    case that: UserGroup => this.id == that.getId
    case _ => false
  }
  //Standar Java getters
  def getId = id
  def getName = name
  def getDescription = description
  def isActive = active
  def getPermissions = permissions
}
