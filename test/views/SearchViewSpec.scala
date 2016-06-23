package views

import model.Types
import org.specs2.mutable.Specification
import play.api.test.FakeApplication
import play.api.test.Helpers._
import org.jsoup.Jsoup

/**
  * Created by tsn3316 on 6/14/16.
  */
class SearchViewSpec extends Specification{

  def getHtml() = {
    running(FakeApplication()) {
      val viewText = views.html.search("pizza",List(Types("normal","small","onion",100)),List("small"),List()).body
      Jsoup.parse(viewText)
    }
  }

  def getHtmlForEmptySizeList() = {
    running(FakeApplication()) {
      val viewText = views.html.search("pizza",List(Types("normal","small","onion",100)),Nil,List()).body
      Jsoup.parse(viewText)
    }
  }

  "Search " should {

    val html=getHtml()
    val htmlFoeEmptyFacet=getHtmlForEmptySizeList()

    "display size facet" in {
      html.select("#content").isEmpty mustEqual false
    }

    "if size is empty then does not show size facet" in {
      htmlFoeEmptyFacet.select("#content").isEmpty mustEqual true
    }

  }

}
