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

    "return item details" in {
      item.getItemdetail("pizza").isEmpty mustEqual false
    }

    "return size list" in {
      item.getSizeList("pizza").isEmpty mustEqual false
    }

    "return filter result" in {
      item.filter(List("small")).isEmpty mustEqual false
    }

    "return pizza bases " in {
      item.baseList().isEmpty mustEqual false
    }

    "return pizza sauce" in {
      item.sauceList().isEmpty mustEqual false
    }

    "return pizza chesse" in {
      item.cheeseList().isEmpty mustEqual false
    }
  }

}
