package pm.core.security

class User(username:String){
  var name: String = ""
  var mail: String = ""
  var groups: List[UserGroup] = Nil

  def hasPermission (permission: String):Boolean = groups.filter( _ ? permission) != Nil
  def ? = hasPermission _

  override def toString = name
  
  // Equality definition
  override def hashCode = 20 * username.hashCode
  override def equals(other: Any) = other match{
    case that: User => this.username == that.getUsername
    case _ => false
  }
  //Standar Java getters
  def getUsername = username
  def getName = name
  def getMail = mail
  
}
