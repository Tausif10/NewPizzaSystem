package controllers

import play.api.mvc.{Action, Controller}
import services.{Order, Bill}

import scala.util.Random

/**
  * Created by tsn3316 on 5/5/16.
  */
class BillController extends Controller{

  def bill=Action{
    request=>
      val orderId=request.session.get("orderID").getOrElse("0")
      val item=request.body.asFormUrlEncoded.get("item")(0)
      val bill=new Bill()
      val orderList=bill.getOrderDetail(orderId.toInt)
      val orderTotal=bill.getOrderTotal(orderList)
      val serviceTax=bill.getServiceTax(orderTotal)
      val vat=bill.getVat(orderTotal)
      val total=orderTotal+vat+serviceTax
      Ok(views.html.bill(item,orderList,orderTotal,serviceTax,vat,total))
  }

  def payBill=Action{
    request=>
      val custName=request.body.asFormUrlEncoded.get("custName")(0)
      val total=request.body.asFormUrlEncoded.get("total")(0)
      val orderId=request.session.get("orderID").getOrElse("")
      val paymentId=Random.nextInt()
      val order=new Order()
      val status=order.pay(orderId.toInt,custName,paymentId,total.toFloat)
      Ok(views.html.success(status)).withNewSession
  }

}

object BillController extends BillController
