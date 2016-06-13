package services

import myUtility.DataBaseConnection

/**
  * Created by tsn3316 on 5/5/16.
  */
class Cart {

  val db=new DataBaseConnection()
  def add(orderId:BigInt,quant:Int,size:String,base:String,topping:String,total:Int,sauce:String,cheese:String)={
    val sql="insert into order_detail(detail_id,quant,size,base,sauce,topping,cheese,total) values("+orderId+","+quant+",'"+size+"','"+base+"','"+sauce+"','"+topping+"','"+cheese+"',"+total+")"
    db.executeSql(sql)
  }

}
