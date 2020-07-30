object Join extends App {
  def joinNL(left:Iterator[Int], right:Iterator[Int]): Iterator[Int] ={
    val buffer = right.toArray
    left.flatMap( l => buffer.filter(r => r == l))

  }
  joinNL( Seq(1,3).toIterator, Seq(1,2,3).toIterator).foreach{
    x => println(x)
  }
}
