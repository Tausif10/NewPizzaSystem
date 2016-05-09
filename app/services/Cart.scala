package services

import myUtility.DataBaseConnection

/**
  * Created by tsn3316 on 5/5/16.
  */
class Cart {

  val db=new DataBaseConnection()
  def add(orderId:BigInt,size:String,base:String,topping:String,total:Int)={
    val sql="insert into order_detail(detail_id,quant,size,base,sauce,topping,cheese,total) values("+orderId+","+1+",'"+size+"','"+base+"','"+""+"','"+topping+"','"+""+"',"+total+")"
    db.executeSql(sql)
  }

}
