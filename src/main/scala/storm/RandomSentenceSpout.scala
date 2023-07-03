package storm
import org.apache.storm.spout.SpoutOutputCollector
import org.apache.storm.task.TopologyContext
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichSpout
import org.apache.storm.tuple.{Fields, Values}

import scala.util.Random

class RandomSentenceSpout extends BaseRichSpout{
  var _collector:SpoutOutputCollector = _
  var _rand:Random = _
  override def nextTuple(): Unit = {
    val words = Array("cow", "apple", "seven", "dwarfs", "nature")
    val word = words(_rand.nextInt(words.length))
    _collector.emit(new Values(word))
  }
  override def open(conf: java.util.Map[_, _], context: TopologyContext, collector: SpoutOutputCollector): Unit = {
    _collector = collector
    _rand = Random
  }

//  override def ack(msgId: Any): Unit = {
//    println("Acknowledge ",msgId)
//    super.ack(msgId)
//  }
//
//  override def fail(msgId: Any): Unit = {
//    println("Failed ",msgId)
//    super.fail(msgId)
//  }

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {
    declarer.declare(new Fields("word"))
  }
}
