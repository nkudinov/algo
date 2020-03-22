package c10

object q0_s extends App{
  private def merge(a:Array[Int],b:Array[Int]):Array[Int] ={
    val ret = new Array[Int](a.length+b.length)
    var i = 0
    var j = 0
    var k = 0
    var e = 0
    while ( i < a.length && j < b.length) {
      if ( a(i) < b(j) ){
        e = a(i)
        i +=1
      } else {
        e = b(j)
        j +=1
      }
      ret(k) = e
      k +=1
    }
    while(i < a.length){
      ret(k) = a(i)
      k +=1
      i +=1
    }
    while(j < b.length){
      ret(k) = b(j)
      k +=1
      j +=1
    }
    return ret;
  }
  def msort(arr:Array[Int]): Array[Int] = {
    if (arr.length >= 2) {
       val arrs = arr.splitAt(arr.length / 2)
       merge( msort(arrs._1), msort(arrs._2))
    } else
       arr
  }
  def qsort(arr:Array[Int]): Array[Int] = {
    if (arr.length >= 2) {
      val e = arr(0)
      qsort(arr.filter(_ < e)) ++ arr.filter(_ == e) ++ qsort(arr.filter(_ > e))
    } else
        arr
  }
  val arr = Array( 10, 1000, 0, 2, 2, -11)
  println( msort(arr).mkString(","))
  println( qsort(arr).mkString(","))
}
