package myUtility

import org.scalatest.{Matchers, FunSpec}

/**
  * Created by tsn3316 on 5/6/16.
  */
class ResultSetToListTest extends FunSpec with Matchers {

  describe("ResultSetToListTest"){
    it("should not return empty list"){
      val rsToList=new ResultSetToList()
      val db=new DataBaseConnection
      val rs=db.getResultSet("select * from item_size")
      rsToList.getSizeList(rs) should not be(Nil)
    }
  }

}
