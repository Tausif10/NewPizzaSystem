package controllers

import play.api.mvc.{Action, Controller}
import services.Order

/**
  * Created by tsn3316 on 5/6/16.
  */
class OrderCancelController extends Controller{

  def cancel=Action{
    request=>
      val orderId=request.session.get("orderID").getOrElse("0")
      val order=new Order()
      val status=order.cancelOrder(orderId.toInt)
      println(orderId)
      Ok(views.html.home()).withNewSession

  }

}
