object q2 extends App {

 def reverse(list:List[Int]):List[Int] = {
   def helper(list:List[Int],acc:List[Int]):List[Int] ={
     list match {
       case Nil   =>  acc
       case x::xs =>  helper(xs, x :: acc)
     }
   }
   helper(list, List.empty[Int])
 }
 println(reverse(List(1,2,3)).mkString(","))
}
