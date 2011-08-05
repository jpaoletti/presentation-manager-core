package pm.core.security

/**
 * A session is a container of the state of a user session. 
 */
class Session(id: String, user: User) {

  override def toString = id + "(" + user + ")"
  // Equality definition
  override def hashCode = 26 * id.hashCode
  override def equals(other: Any) = other match{
    case that: Session => this.id == that.getId
    case _ => false
  }
  //Standar Java getters
  def getId = id
  def getUser = user
}

/**
 * Main objective of this singleton is to generate ids for sessions
 */
object Session {
  private var sessionIdSeed = 0L;
  def generateId: String = {
    sessionIdSeed+= 1;
    ("session" + sessionIdSeed).hashCode.toString();
  }
}