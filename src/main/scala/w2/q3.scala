package w2

object  q3 extends App {
  val maxPartitions = 3
  val prev_partitions_length = 10
  for (i <- 0 until maxPartitions) {
    val rangeStart = ((i.toLong * prev_partitions_length) / maxPartitions).toInt
    val rangeEnd = (((i.toLong + 1) * prev_partitions_length) / maxPartitions).toInt
    println("i= "+i+ " ["+rangeStart+","+rangeEnd+"]")
    //(rangeStart until rangeEnd).foreach{ j => groupArr(i).partitions += prev.partitions(j) }
  }
  val step = prev_partitions_length/maxPartitions
  for(i <- 0 until maxPartitions){
    val rangeStart = i *step
    val rangeEnd = (i+1)*step
    println("i= "+i+ " ["+rangeStart+","+rangeEnd+"]")
  }
}
