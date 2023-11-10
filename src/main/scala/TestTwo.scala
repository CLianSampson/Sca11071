import scala.collection.mutable

/**
 * https://blog.csdn.net/qq_46893497/article/details/110790395
 */
object TestTwo {

  def main(args: Array[String]): Unit = {
    //1.准备数据
    val lines = List("hadoop hive spark flink flume", "spark spark hadoop hbase sqoop storm")
    //2.准备一个空的可变集合用来储存结果如:单词->数量,map的kv结构
    val map = mutable.Map[String, Int]()
    //3.将数据中的单词变成一个个的拆分出来放到一个集合中
    val words: List[String] = lines.flatMap(_.split(" "))
    //println(words)
    //List(hadoop, hive, spark, flink, flume, spark, spark, hadoop, hbase, sqoop, storm)
    //4.遍历words单词,并判断map中是否有这个单词
    for (word <- words) {
      /*if (map.contains(word)) { //map中存在该单词
        val count: Int = map(word) //取出原来的count
        map.put(word, count + 1) //将原来的count+1之后覆盖之前的值
      } else { //map中不存在该单词,直接记为(单词,1)
        map.put(word, 1)
      }*/
      //上面的逻辑就是从map中取出word对应的数量如果有则取出来+1,没有则为0+1,那么可以使用下面一行代码搞定
      map.put(word, map.getOrElse(word,0) + 1)
    }
    //循环结束,map中就存放了WordCount的结果
    //可以直接打印map
    //println(map)
    //Map(spark -> 3, hadoop -> 2, sqoop -> 1, flink -> 1, hive -> 1, storm -> 1, flume -> 1, hbase -> 1)

    //也可以遍历map
    //map.foreach((t:(String,Int))=>println(t._1,t._2))
    //map.foreach(t=>println(t._1,t._2))
    map.foreach{case (k,v) => println(k,v)} //模式匹配--先看懂输出,后面会学
    //(spark,3)
    //(hadoop,2)
    //(sqoop,1)
    //(flink,1)
    //(hive,1)
    //(storm,1)
    //(flume,1)
    //(hbase,1)
  }


}
