package services

import java.util.Calendar

import myUtility.DataBaseConnection

/**
  * Created by tsn3316 on 5/5/16.
  */
class Order {

  val db=new DataBaseConnection()

  def pay(orderId:Int,custName:String,paymentId:Int,total:Float): Int ={
    val date=Calendar.getInstance().getTime
    val sql="insert into order1 values("+orderId+",'"+custName+"',"+paymentId+","+total+","+"'"+date+"')"
    db.executeSql(sql)
  }

  def cancelOrder(orderId:Int)={
    val sql="delete from order_detail where detail_id in("+orderId+","+0+")"
    val s=db.executeSql(sql)
    val sql1="delete from order1 where order_id in("+orderId+","+0+")"
    db.executeSql(sql1)
  }
}
