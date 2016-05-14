/**
  * Created by raghu on 4/6/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext

object Query6 {


  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val sc = new SparkContext("local[2]","PbSpark")
    val sqlContext = new SQLContext(sc);
    val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv");
    tweets.registerTempTable("tweets_1");

    val s1 = sqlContext.sql("SELECT user.time_zone,substr(created_at,9,11),count(*) as active from tweets_1 where user.time_zone is not null group by user.time_zone,substr(created_at,9,11) order by active desc limit 15");
    s1.show()
    s1.save("Query6","json")
  }
}
