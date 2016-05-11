package controllers

import play.api.mvc.{Action, Controller}
import services.Cart

import scala.util.Random

/**
  * Created by tsn3316 on 5/5/16.
  */
class AddToCartController extends Controller{

  def addToCart=Action{
    request=>
      val size=request.getQueryString("Size").getOrElse("")
      val base=request.getQueryString("base").getOrElse("")
      val topping=request.getQueryString("Topping").get
      val total=request.getQueryString("total").getOrElse("0")
      val item=request.getQueryString("item").getOrElse("0")

      val orderId= if(request.session.get("orderID").isEmpty){
        Random.nextInt()
      }else{
        request.session.get("orderID").get.toInt
      }

      val cart=new Cart()
      val status=cart.add(orderId,size,base,topping,total.toInt)
      Ok(views.html.addToCart(status,item)).withSession("orderID"->orderId.toString)
  }

}

object  AddToCartController extends AddToCartController