package controllers

import play.api.mvc.{Action, Controller}
import services.{Cart, CustomPizza}

import scala.util.Random

/**
  * Created by tsn3316 on 5/5/16.
  */
class AddToCartController extends Controller{

  def addToCart=Action{
    request=>
      val size=request.getQueryString("Size").getOrElse("")
      val base=request.getQueryString("base").getOrElse("")
      val topping=request.queryString.get("Topping").getOrElse(Nil).toList
      val total=request.getQueryString("total").getOrElse("0")
      val item=request.getQueryString("item").getOrElse("")
      val sauce=request.getQueryString("sauce").getOrElse("")
      val cheese=request.getQueryString("cheese").getOrElse("")
      val quantity=request.getQueryString("quant").getOrElse("1")
      val isCustomPizza=request.getQueryString("isCustomPizza").getOrElse("false")

      val totalBill=if(isCustomPizza.toBoolean){
        val sum=new CustomPizza(base,size).total()
        sum.toInt*quantity.toInt
      }else{
        total.toInt*quantity.toInt
      }

      val orderId= if(request.session.get("orderID").isEmpty){
        Random.nextInt()
      }else{
        request.session.get("orderID").get.toInt
      }

      val cart=new Cart()
      val status=cart.add(orderId,quantity.toInt,size,base,topping.mkString(","),totalBill,sauce,cheese)
      println(">>>>>>orderid="+orderId)
      Ok(views.html.addToCart(status,item)).withSession("orderID"->orderId.toString)
  }
}

object  AddToCartController extends AddToCartController