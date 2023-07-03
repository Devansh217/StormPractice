//package storm
//
//import org.apache.storm.{Config, LocalCluster}
//import org.apache.storm.topology.TopologyBuilder
//import org.apache.storm.tuple.Fields
//
//object WordCountTopology {
//  def main(args: Array[String]): Unit = {
//    println("Hello world!")
//    val builder = new TopologyBuilder
//    builder.setSpout("spout", new RandomSentenceSpout, 5)
//    builder.setBolt("count", new WordCountBolt, 3)
//           .fieldsGrouping("spout", new Fields("word"))
//
//    val conf = new Config()
//    conf.setDebug(true)
//    conf.setMaxTaskParallelism(3)
//
//    val cluster = new LocalCluster
//    cluster.submitTopology("word-count", conf, builder.createTopology())
//    Thread.sleep(5000)
//    println("Goodbye, world!")
//    cluster.shutdown()
//    println("I am Dead!")
//  }
//}
