package futureScope.examples

import scala.concurrent.*

import cps.*
import cps.monads.{*,given}
import cps.testconfig.given

import futureScope.*

/*
 * The task is read first N urls from given list of urls.
 * The urls are read in parallel, but we need to stop reading after N urls are read.
 */
object TenUrls {

  import scala.concurrent.ExecutionContext.Implicits.global


  def readFirstN(networkApi: NetworkApi, urls: Seq[String], n:Int)(using ctx:FutureScopeContext): Future[Seq[String]] = 
    async[Future].in(Scope.child(ctx)) {
      val all = FutureGroup.collect( urls.map(url =>  networkApi.fetch(url)) )
      val successful = all.events.inTry.filter(_.isSuccess).take[Seq](n)
      await(successful).map(_.get)
    }
  

  trait NetworkApi {

    
    def fetch(url: String)(using ctx: FutureScopeContext): Future[String] 

 }


}