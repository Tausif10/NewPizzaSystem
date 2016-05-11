package controllers


import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

class HomeController extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def home = Action {
    Ok(views.html.home())
  }
}

object HomeController extends HomeController