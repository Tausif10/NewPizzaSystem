package myUtility

import java.sql.DriverManager

/**
  * Created by tsn3316 on 5/4/16.
  */
class DataBaseConnection {

  private def getConnection={
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://localhost/myPizzaSystem","root","")
  }

  def getResultSet(sql:String)={
    val con=getConnection
    val st=con.createStatement()
    st.executeQuery(sql)
  }

  def executeSql(sql:String):Int={
    val con=getConnection
    val st=con.createStatement()
    st.executeUpdate(sql)
  }
}
