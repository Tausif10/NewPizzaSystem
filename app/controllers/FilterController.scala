package controllers

import model.Types
import myUtility.DataBaseConnection
import play.api.mvc.{Action, Controller}
import services.getItemTypes

/**
  * Created by tsn3316 on 5/5/16.
  */
class FilterController extends Controller{

  def filter=Action{
    request=>
      val itemDetail=new getItemTypes
      val item=request.body.asFormUrlEncoded.get("item")(0)
      val sizes=itemDetail.getSizeList(item)
      val chk=request.body.asFormUrlEncoded.get.getOrElse("size",Nil)
      val itemId=request.session.get("itemId").getOrElse("0")
      val itemDetails=new getItemTypes()

      val detailList=if(chk.isEmpty){
        itemDetails.getItemdetail(item)
      }else{
        itemDetails.filter(chk.toList)
      }
      Ok(views.html.search(item,detailList,sizes,chk.toList))

  }

}
