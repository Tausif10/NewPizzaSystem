package services

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

/**
  * Created by tsn3316 on 5/11/16.
  */
class CartTest extends Specification with Mockito {

  "it" should {
    "add the order into cart" in{
      val cart=new Cart
      cart.add(0,0,"small","normal","onion",100,"","") mustEqual(1)
    }
  }

}
