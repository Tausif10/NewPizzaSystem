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
  request=>
    val orderId=request.session.get("orderID").getOrElse(0)
    println(">>>>>"+orderId)
    Ok(views.html.home()).withSession("orderID"->orderId.toString)
  }

  def customPizza = Action {
    val itemDetails=new getItemTypes()
    val sizes=itemDetails.getSizeList("pizza")
    val baseList=itemDetails.baseList()
    val sauceList=itemDetails.sauceList()
    val topping=itemDetails.toppingList()
    val cheeses=itemDetails.cheeseList()
    Ok(views.html.customPizza(sizes,baseList,sauceList,topping,cheeses))
  }
}

object HomeController extends HomeController