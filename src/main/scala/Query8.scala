/**
  * Created by raghu on 4/6/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext


object Query8 {

  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val sc = new SparkContext("local[2]","PbSpark")
    val sqlContext = new SQLContext(sc);
    val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv");
    tweets.registerTempTable("tweets_1");

    val s1 = sqlContext.sql("SELECT count(*) from tweets_1 where text like '%#music'");
    s1.show()
    s1.save("Query8","json")
  }
}
