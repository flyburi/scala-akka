import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _       => println("huh?")
  }
}

object HelloAkka extends App {
  // ActorSystem is a heavy object: create only one per application
  val system = ActorSystem("HelloSystem")

  //액터는 ActorSystem 및 ActorContext에서 사용할 수있는 actorOf 팩토리 메서드에 Props 인스턴스를 전달하여 만듭니다.
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"
}