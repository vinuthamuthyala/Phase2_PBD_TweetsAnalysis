
/**
  * Created by raghu on 4/7/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext

object Sample {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val sc = new SparkContext("local[2]","PbSpark")
    val sqlContext = new SQLContext(sc);
    val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv");
    tweets.registerTempTable("tweets_1");

    val s1 = sqlContext.sql("Select count(*)-count(CASE WHEN user.verified like '%true%' then 'true'  END) as non_verified_users,count(CASE WHEN user.verified like '%true%' then 'true'  END)as verified_users from tweets_1");
    s1.show()
    s1.save("Sample","json")
  }
}
