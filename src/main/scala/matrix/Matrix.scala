package matrix
case class ROW(val row:Int*)
case class COLUMN(val col:Int*)
class Matrix( arr:Array[Array[Int]]) {
  def n():Int = {
    arr.length
  }
  def m():Int = {
    arr(0).length
  }
  def rows():Array[ROW] = {
    arr.map(x => ROW(x:_*))
  }
  def cols():Array[COLUMN] = {
    val ret = Array.ofDim[COLUMN](arr(0).length)
    for( j <- 0 until m()){
       ret(j)= COLUMN((for (i <- 0 until n()) yield {arr(i)(j)}):_*)
    }
    ret
  }

  def this(cols:Array[ROW]) ={
    this( Matrix.fromROWS(cols))
  }

  def this(cols:Array[COLUMN]) ={
    this( Matrix.fromCOLS(cols))
  }
  private def multyply(r:ROW, c:COLUMN):Int = {
    r.row.zip(c.col).map( p => p._1*p._2).sum
  }
  def * (other:Matrix): Matrix = {
    require(m() == other.n())
    val tmp = for( col <- other.cols()) yield {
      val column  = for( row <- rows()) yield { multyply( row, col)}
      COLUMN(column: _*)
    }
    new Matrix(tmp)
  }

  def print: Unit = {
    for( row <- rows){
      println( row.row.toArray.mkString(","))
    }
  }

}
object Matrix{
  private def fromROWS(rows:Array[ROW]):Array[Array[Int]] ={
    val n = rows.length
    val m = rows(0).row.size
    val arr = Array.ofDim[Int](n,m)
    for( i <- 0 until n) {
      for(j <- 0 until m ){
        arr(i)(j) = rows(i).row(j)
      }
    }
    arr
  }
  private def fromCOLS(cols:Array[COLUMN]):Array[Array[Int]] ={
    val n = cols(0).col.size
    val m = cols.length
    val arr = Array.ofDim[Int](n,m)
    for( i<- 0 until n) {
      for(j <- 0 until m ){
        arr(i)(j) = cols(j).col(i)
      }
    }
    arr
  }

}
object Test extends App {

  val m1 = new Matrix(Array(ROW(-1,1),ROW(2,0),ROW(0,3)))
  val m2 = new Matrix(Array(ROW(3,1,2),ROW(0,-1,4)))

  m1.print

  m2.print
  (m1*m2).print
}
