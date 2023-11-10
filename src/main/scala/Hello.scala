import org.apache.spark.{SparkConf, SparkContext}


object Hello {
  def main(args: Array[String]): Unit = {
    println("hello scala")
    val conf :SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    val sc = new SparkContext(conf)

    sc.textFile("input").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).saveAsTextFile("output")

    Thread.sleep(3 * 60 *1000)

    sc.stop()
  }



}