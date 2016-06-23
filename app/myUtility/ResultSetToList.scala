package myUtility

import java.sql.ResultSet

import model.{Order, Types}

/**
  * Created by tsn3316 on 5/5/16.
  */
class ResultSetToList {


  def getDetailList(rs:ResultSet)={
    var list:List[Types]=Nil

    val db=new DataBaseConnection()
    while (rs.next()){
      val itemSize=db.getResultSet("select * from item_size where size_id="+rs.getInt("size_id"))
      while (itemSize.next()){
        list=list:::Types(rs.getString("type"),itemSize.getString("size"),rs.getString("detail"),rs.getInt("price"))::Nil
      }
    }
    list
  }
Int
  def getSizeList(rs:ResultSet)={
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("size")::Nil
    }
    list
  }

  def getzItemId(rs:ResultSet)={
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("item_id")::Nil
    }
    list
  }

  def getOrderList(rs:ResultSet)={
    var list:List[Order]=Nil
    while(rs.next()){
      val detail=rs.getInt("quant")+" | "+rs.getString("size")+" | "+rs.getString("base")+" | "+rs.getString("sauce")+" | "+
        rs.getString("topping")+rs.getString("cheese")
      list=list:::Order(detail,rs.getInt("total"))::Nil
    }
    list
  }

  def getBaseList(rs:ResultSet) = {
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("base")::Nil
    }
    list
  }

  def getSauceList(rs:ResultSet) = {
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("sauce")::Nil
    }
    list
  }

  def getToppingList(rs:ResultSet) = {
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("topping")::Nil
    }
    list
  }

  def getCheeseList(rs:ResultSet) = {
    var list:List[String]=Nil
    while(rs.next()){
      list=list:::rs.getString("cheese")::Nil
    }
    list
  }
}
