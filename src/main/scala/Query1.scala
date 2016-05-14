/**
  * Created by raghu on 4/6/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext

object Query1 {


      def main(args: Array[String]) {
        System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
      // initialise spark context
      val sc = new SparkContext("local[2]","PbSpark")
      val sqlContext = new SQLContext(sc);
      val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv");
      tweets.registerTempTable("tweets_1");

      val s1 = sqlContext.sql("SELECT user.name,max(user.followers_count) as follower_count FROM tweets_1 where user.followers_count is not null group by user.name order by follower_count desc limit 10");
        s1.show()
        s1.save("Query1","json")
    }
  }







