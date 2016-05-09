package services

import myUtility.{ResultSetToList, DataBaseConnection}

/**
  * Created by tsn3316 on 5/5/16.
  */
class getItemTypes {
 private val db=new DataBaseConnection()
 private val rsToList=new ResultSetToList()


  def getItemId(item:String)={
    val sql="select * from items where item='"+item.toLowerCase+"'"
    val items=db.getResultSet(sql)
    rsToList.getzItemId(items)

  }
  def getItemdetail(item:String)={
    if(item.isEmpty){
       Nil
    }else{
      val id=getItemId(item)
      val itemId=id.mkString("")
      val sql="select * from item_types where item_id="+itemId.toInt
      val types=db.getResultSet(sql)
      rsToList.getDetailList(types)
    }

  }

  def getSizeList(item:String)={
    val sql="select * from item_size where item_id=(select item_id from items where item='"+item.toLowerCase+"')"
    val types=db.getResultSet(sql)
    rsToList.getSizeList(types)
  }

  def filter(sizes:List[String])={
    println("size List= "+sizes.mkString("'","','","'"))
    val sql="select * from item_types where size_id in (select size_id from item_size where size in("+sizes.mkString("'","','","'").toLowerCase+"))"
    val filterRs=db.getResultSet(sql)
    rsToList.getDetailList(filterRs)
  }




}
