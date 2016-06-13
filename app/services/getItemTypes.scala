package services

import myUtility.{ResultSetToList, DataBaseConnection}

/**
  * Created by tsn3316 on 5/5/16.
  */
class getItemTypes {
 private val db=new DataBaseConnection()
 private val rsToList=new ResultSetToList()


  def getItemId(item:String) = {
    val itm=item.split(" ")
    val sql="select * from items where item in("+itm.mkString("'","','","'").toLowerCase+")"
    val items=db.getResultSet(sql)
    val itemId=rsToList.getzItemId(items)
    if(!itemId.isEmpty){
      itemId(0).toInt
    }else{
      0
    }
  }

  def getItemdetail(item:String) = {
    if(item.isEmpty) {
       Nil
    } else {
      val id=getItemId(item)
      if(id!=0) {
        val sql = "select * from item_types where item_id=" + id
        val types = db.getResultSet(sql)
        rsToList.getDetailList(types)
      }else{
        Nil
      }
    }
  }

  def getSizeList(item:String) = {
    val itm=item.split(" ")
    val sql="select * from item_size where item_id=(select item_id from items where item in("+itm.mkString("'","','","'").toLowerCase+"))"
    val types=db.getResultSet(sql)
    rsToList.getSizeList(types)
  }

  def filter(sizes:List[String]) = {
    val sql="select * from item_types where size_id in (select size_id from item_size where size in("+
      sizes.mkString("'","','","'").toLowerCase+"))"
    val filterRs=db.getResultSet(sql)
    rsToList.getDetailList(filterRs)
  }

  def baseList() = {
    val sql="select * from pizzaBase"
    val bases=db.getResultSet(sql)
    rsToList.getBaseList(bases)
  }

  def sauceList() = {
    val sql="select * from pizzaSauce"
    val sauces=db.getResultSet(sql)
    rsToList.getSauceList(sauces)
  }

  def toppingList() = {
    val sql="select * from topping"
    val topping=db.getResultSet(sql)
    rsToList.getToppingList(topping)
  }

  def cheeseList() = {
    val sql="select * from cheese"
    val cheese=db.getResultSet(sql)
    rsToList.getCheeseList(cheese)
  }
}
