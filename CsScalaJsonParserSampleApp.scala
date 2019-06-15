package cs.scala.json.parser.sample

import java.nio.charset.StandardCharsets

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization

object CsScalaJsonParserSampleApp extends App {

  implicit val json4sFormats = DefaultFormats
  
  val yourBytes: Array[Byte] = "somebytes".getBytes(StandardCharsets.UTF_8)

  val list: List[String] = List("a", "aa")

  val map = Map("query" -> yourBytes, "abc" -> list)

  val json = Serialization.writePretty(map)

  println(json)

}