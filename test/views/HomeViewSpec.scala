package views

import org.specs2.mutable.Specification
import play.api.test.FakeApplication
import play.api.test.Helpers._
import org.jsoup.Jsoup

/**
  * Created by tsn3316 on 6/8/16.
  */
class HomeViewSpec extends Specification{

  def getHtml() = {
    running(FakeApplication()) {
      val viewText = views.html.home().body
      Jsoup.parse(viewText)
    }
  }

  "Home page" should {

    val html=getHtml()

    "Heading must be" in {
      html.select("#head h1").text mustEqual "Pizza Hut"
    }

    "url for custom Pizza" in {
      html.select("#custPizza a").attr("href") mustEqual "/customPizza"
      html.select("#custPizza a").text mustEqual "Get custom Pizza"
    }

    "search button have correct lable" in {
      html.select("#searchBtn").attr("value") mustEqual "Search"
    }

    "having correct image" in {
      html.select("#custPizza img").attr("src") mustEqual "/assets/images/pizza1.jpg"
    }
  }

}
