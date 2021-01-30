package com.pat


import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.Cluster
import akka.management.cluster.bootstrap.ClusterBootstrap
import akka.management.scaladsl.AkkaManagement
import com.typesafe.config.ConfigFactory

object Node1 extends App {
  new Guardian(1)
}

object Node2 extends App {
  new Guardian(2)
}

object Node3 extends App {
  new Guardian(3)
}

object StartNode {
  def main(args: Array[String]): Unit = {
    new Guardian(1)
  }
}

class Guardian(nr: Int) {
  //  def config = ConfigFactory.parseString(
  //    s"""
  //      akka.remote.artery.canonical.hostname = "127.0.0.$nr"
  //      akka.management.http.hostname = "127.0.0.$nr"
  //    """).withFallback(ConfigFactory.load("application-old.conf"))

  def config = ConfigFactory.load("application.conf")

  val system = ActorSystem[Nothing](Behaviors.empty, "local-cluster", config)
  AkkaManagement(system).start()
  ClusterBootstrap(system).start()
  Cluster(system).registerOnMemberUp({
    system.log.info("Cluster is up!")
  })
}