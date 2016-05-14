/**
  * Created by raghu on 4/6/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext
object Query4 {



  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val sc = new SparkContext("local[2]","PbSpark")
    val sqlContext = new SQLContext(sc)
    val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv")
    tweets.registerTempTable("tweets_1")

    val s1 = sqlContext.sql("SELECT user.time_zone,count(*) as timeszone from tweets_1 where user.time_zone is not null group by user.time_zone order by timeszone desc limit 7")
    s1.show()
    s1.save("Query4","json")



  }
}
