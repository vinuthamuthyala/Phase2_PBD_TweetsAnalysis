/**
  * Created by raghu on 4/6/2016.
  */
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.util
import org.apache.spark.sql.SQLContext
object Quey7 {



  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\raghu\\Desktop\\PBD\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val sc = new SparkContext("local[2]","PbSpark")
    val sqlContext = new SQLContext(sc);
    val tweets = sqlContext.jsonFile("C:\\Users\\raghu\\Desktop\\PBD\\tweets.csv");
    tweets.registerTempTable("tweets_1");

    val s1 = sqlContext.sql("SELECT possibly_sensitive, count(*)  FROM tweets_1 where possibly_sensitive is not null group by possibly_sensitive limit 3");
    s1.show();
    s1.save("Query7","json")
  }
}
