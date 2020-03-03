object SieveOfEratosthenes extends App{

   def make(n:Int): List[Int] = {
     var list  = Range(2,n+1).toList
     for( e <- Range(2,Math.sqrt(n+1).toInt)){
       list = list.filter(x => x == e || x %e != 0)
     }
     list
   }
   println(make(30))
}
