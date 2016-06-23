package services

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

/**
  * Created by tsn3316 on 6/23/16.
  */
class OrderTest extends Specification with Mockito{

  "Order" should {
    val order=new Order

    "pay a bill" in {
      order.pay(0,"abc",1,10) mustNotEqual  0
    }

    "cancel order" in {
      order.cancelOrder(0) mustNotEqual 0
    }
  }

}
