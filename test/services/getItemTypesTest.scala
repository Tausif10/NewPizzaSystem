package services

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

/**
  * Created by tsn3316 on 5/11/16.
  */
class getItemTypesTest extends Specification with Mockito {

  "it" should {
    val item=new getItemTypes
    "give item id" in{
      item.getItemId("pizza") mustEqual(1)
    }
  }

}
