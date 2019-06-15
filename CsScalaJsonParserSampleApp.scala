package cs.scala.json.parser.sample

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization

case class WorkFlow(name:String, steps:List[Step])
case class Step(name: String, operatorName: String, stepNumber: Option[Int], primary: Option[Primary])
case class Primary(keyname: String, datatype:Int)

object CsScalaJsonParserSampleApp extends App {

  val jsonString = """
    {
      "name": "joe",
      "steps": [
        {
          "name": "sort1",
          "operatorName": "sort",
          "stepNumber": 1
        },
        {
          "name": "join1",
          "operatorName": "join",
          "primary": {
            "keyname": "customerID",
            "datatype": "Int"
          }
        }
      ]
    }"""

  implicit val json4sFormats = DefaultFormats
  
  val workflowFromJson = JsonMethods.parse(jsonString).extract[WorkFlow]

  println(s"Extracted as Scala object: ${workflowFromJson}")

  val newWorkflow = WorkFlow("test", List(Step("step1", "opn1", Some(1), None), Step("step2", "opn2", None, Some(Primary( "kn2", 2)))))

  val newWorkflowAsJson = Serialization.writePretty(newWorkflow) // here you can also use write for getting an slimmer JSON

  println(s"JSON from an Scala object: ${newWorkflowAsJson}")

}