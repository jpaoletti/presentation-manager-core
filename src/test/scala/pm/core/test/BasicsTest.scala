package pm.core.test

import junit.framework._
import Assert._
import pm.core._
import pm.core.security._

object BasicsTest {
  def suite: Test = {
    val suite = new TestSuite(classOf[BasicsTest]);
    suite
  }

  def main(args : Array[String]) {
    junit.textui.TestRunner.run(suite);
  }
}

/**
 * Basic unit test
 */
class BasicsTest extends TestCase("basic") {

  def testBasicEntity:Unit = {
    val entity1 =
      new Entity("test", "some.model.Class",null,
                 new Field("field1") :: new Field("field2") :: Nil
      )

    val entity2 =
      new Entity("test2","some.model.Class2",entity1,
                 new Field("field1") :: new Field("field3") :: new Field("field4") :: Nil
      )

    //Check inheritance
    assert(entity1.getFields.size == 2)
    assert(entity2.getFields.size == 4)

    val entities = entity1 :: entity2 :: Nil
    
    val pm = new PresentationManager(null)
    entities.foreach(pm.addEntity _)
    
    pm.entities.foreach{ case (id,e) => {
          println(e)
          assert(e.toString == id + "("+e.getClazz+")")
          e.getFields.foreach( println )
          e.getFields.foreach( field => assert(field.entity == e) )
        }
    }
    println("")
  }


  def testSecurity: Unit = {
    val perms = new Permission("login") :: new Permission("sysadmin") :: Nil

    val user = new User("admin")
    user.name="System Admin"
    assert(user.getUsername == "admin")
    println(user)

    user.groups = new UserGroup("sysadmins") :: Nil
    user.groups.foreach(g => g.permissions = perms)

    //Check permissions
    assertTrue ( user ? "login" )
    assertFalse( user ? "invalid" )

    val session = new Session(Session.generateId, user)
    val pm = new PresentationManager(null)
    pm.addSession(session)
    pm.sessions.foreach{ case (id,s) => {
          assertTrue(id == s.getId)
          println(s)
        }
    }
    println("")
  }
}
