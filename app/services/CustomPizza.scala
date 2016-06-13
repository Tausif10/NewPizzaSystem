package services

/**
  * Created by tsn3316 on 6/8/16.
  */
class CustomPizza(base:String,size:String) {

  private def getPrice() = {
    size.toLowerCase() match {
      case "small" =>

        base.toLowerCase match {
          case "normal" => 75

          case "pan crust" => 100

          case "thin crust" => 125
        }

      case "medium" =>
        base.toLowerCase match {
          case "normal" => 75 * 25 / 100 + 75

          case "pan crust" => 100 * 25 / 100 + 100

          case "thin crust" => 125 * 25 / 100 + 125
        }

      case "large" =>
        base.toLowerCase match {
          case "normal" => 75 * 50 / 100 + 75

          case "pan crust" => 100 * 50 / 100 + 100

          case "thin crust" => 125 * 50 / 100 + 125
        }
    }
  }

    def total() = {
      val sum=getPrice()+toppingPrice()+cheesePrice()
      sum
    }

    private def toppingPrice() = {
      size.toLowerCase() match {
        case "small" => 15

        case "medium" => 30

        case "large" => 45
      }
    }

    private def cheesePrice() = {
      size.toLowerCase() match {
        case "small" => 15

        case "medium" => 30

        case "large" => 45
      }
    }


}
