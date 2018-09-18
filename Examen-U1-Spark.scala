//EXAMEN SPARK 
//1.
import org.apache.spark.sql.SparkSession

val exa = SparkSession.builder().getOrCreate()
//2.
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3.
df.columns

//4.
df.printSchema()


//5.
df.head(5)

//6.
df.describe().show()

//7.
val df2 = df.withColumn("HV_Ratio", df("High")+df("Volume"))
df2.select("HV_Ratio").show()

//8.
df.select(max("High")).show() 

//9.
df.select(avg("close")).show()

//10.
df.select(max("Volume")).show()
df.select(min("Volume")).show()

//11.
//a)
import spark.implicits._
val df3 =df.withColumn("Day", dayofyear(df("Date")))
val dlla = df3.drop("Date", "Open", "High", "Low", "Volume", "Adj Close")
dlla.createOrReplaceTempView("Net")
val sqlDF= spar.sql("SELECT COUNT(DAY) FROM Net WHERE Close < 600")
sqlDF.show()

//b)
(df.filter($"High" > 500)).count()*1.0 / df.count() * 100

//c)
df.select(corr("High", "Low")).show()

//d)
val df5 = df.withColumn("Year", year(df("Date")))
val dfmax = df5.groupBy("Year").max()
dfmax.select($"Year", $"Max(High)").show()

//e)
val df6 = df.withColumn("Month", month(df("Date")))
val dfavg = df6.groupBy("Month").mean()
dfavg.select($"Month", $"avg(Close)").show()
