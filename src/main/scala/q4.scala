object sq4 extends App {
  def replaceSpaces(str:String):String ={
    str.flatMap( e => if ( e == ' ') Seq('%','2','0') else Seq(e) )
  }
  println(replaceSpaces("Hello worlds"))
}
