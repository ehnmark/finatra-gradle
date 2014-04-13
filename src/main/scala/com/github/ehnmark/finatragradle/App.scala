package com.github.ehnmark.finatragradle

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

class MyView(val user: String) extends View {
	val template = "templates/index.mustache"
}

class MyController extends Controller {
	get("/template/:user") { request => 
		val user = request.routeParams.getOrElse("user", "anonymous")
		val view = new MyView(user)
		render.view(view).toFuture
	}

	get("/plain") { request => 
		render.plain("it works!").toFuture
	}

	get("/json") { request => 
		val map = Map("apa" -> 1, "bpa" -> 2)
		render.json(map).toFuture
	}
}

object App extends FinatraServer {
	register(new MyController())
}