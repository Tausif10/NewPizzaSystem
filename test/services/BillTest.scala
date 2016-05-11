package services

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification


class BillTest extends Specification with Mockito{

  val order=new Bill
  "it" should {
    "give order total detail" in {
      order.getOrderDetail(0) mustEqual (Nil)
    }

    "give order total" in {
      val orderList = order.getOrderDetail(0)
      order.getOrderTotal(orderList) mustEqual (0)
    }

    "give service tax(5%) on order total" in {
      order.getServiceTax(100) mustEqual (5)
    }

    "give vat(6%) on order total" in {
      order.getVat(100) mustEqual(6)
    }
  }
}
