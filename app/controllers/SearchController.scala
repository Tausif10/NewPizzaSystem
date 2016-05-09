package controllers

import play.api.mvc.{Action, Controller}
import services.getItemTypes

/**
  * Created by tsn3316 on 5/4/16.
  */
class SearchController extends Controller{

  def search=Action{
    request=>
      val item=request.body.asFormUrlEncoded.get("item")(0)
      val itemDetails=new getItemTypes()
      val sizes=itemDetails.getSizeList(item)
      val detailList=itemDetails.getItemdetail(item)
      val itemId=itemDetails.getItemId(item)
      if(item.isEmpty){
        Ok(views.html.home())
      }else{
        Ok(views.html.search(item,detailList,sizes,Nil)).withSession("itemId"->itemId(0).toString())
      }
  }

}
