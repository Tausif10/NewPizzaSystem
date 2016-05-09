package model

import org.scalatest.{Matchers, FunSpec}

/**
  * Created by tsn3316 on 5/6/16.
  */
class TypesTest extends FunSpec with Matchers{

  describe("Types"){
    it("detail should not be empty and total should not be zero"){
      val ty=Types("xvxcv","csfsf","sdfsf",10)
      ty.detail.isEmpty should not be(true)
      ty.price should not be(0)
    }
  }

}
