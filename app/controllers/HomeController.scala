package controllers


import play.api.mvc._
import services.getItemTypes

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

class HomeController extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def home = Action {
    Ok(views.html.home())
  }

  def customPizza = Action {
    val itemDetails=new getItemTypes()
    val sizes=itemDetails.getSizeList("pizza")
    val baseList=itemDetails.baseList()
    val sauceList=itemDetails.sauceList()
    val topping=itemDetails.toppingList()
    val cheeses=itemDetails.cheeseList()
    println(">>>>>>"+cheeses)
    Ok(views.html.customPizza(sizes,baseList,sauceList,topping,cheeses))
  }
}

object HomeController extends HomeController