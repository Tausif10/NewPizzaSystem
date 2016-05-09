package model

import org.scalatest.{Matchers, FunSpec}

/**
  * Created by tsn3316 on 5/6/16.
  */
class OrderTest extends FunSpec with Matchers {
  describe("Order"){
    it("Order total should not be zero"){
      val order=new Order("",10)
      order.total should not be(0)
    }
  }

}
