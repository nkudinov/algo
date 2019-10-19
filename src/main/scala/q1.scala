object q1 extends App {
 def isAllUnique1(str:String)= {
   str.groupBy(identity).forall(_._2.length == 1)
 }
  println(isAllUnique1("h"))
}
