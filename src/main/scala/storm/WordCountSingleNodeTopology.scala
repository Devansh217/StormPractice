package storm

import org.apache.storm.generated.{AlreadyAliveException, InvalidTopologyException}
import org.apache.storm.{Config, StormSubmitter}
import org.apache.storm.topology.TopologyBuilder
import org.apache.storm.tuple.Fields

object WordCountSingleNodeTopology {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val builder = new TopologyBuilder
    builder.setSpout("spout", new RandomSentenceSpout, 5)
    builder.setBolt("count", new WordCountBolt, 3)
      .fieldsGrouping("spout", new Fields("word"))

    val conf = new Config()
    conf.setDebug(true)
    conf.setMaxTaskParallelism(3)
    try {
      StormSubmitter.submitTopology("word-count", conf, builder.createTopology())
    }
    catch {
      case a:AlreadyAliveException => println("AlreadyAliveException",a)
      case i:InvalidTopologyException => println("InvalidTopologyException",i)
    }
    //val cluster = new LocalCluster

    Thread.sleep(5000)
    println("Goodbye, world!")
    //cluster.shutdown()
    //println("I am Dead!")
  }
}
