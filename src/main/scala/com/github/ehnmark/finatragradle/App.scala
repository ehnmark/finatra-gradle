package com.github.ehnmark.finatragradle

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

class MyController extends Controller {
	get("/") { request => 
		render.plain("it works!").toFuture }
}

object App extends FinatraServer {
	register(new MyController())
}