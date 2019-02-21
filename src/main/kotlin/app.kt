import io.javalin.Javalin

val db = KweetDb().apply {
    add("ruxmind", "my first kweet")
    add("ruxmind", "this is so fun")
    add("alice", "wow it's like kookge minus!")
    add("jack", "looks like an unicorn startup!")
    add("ruxmind", "@alice @jack let's make it viral!")
    add("jack", "@ruxmind did you use ruby or kotlin?")
    add("alice", "I like this anti-social network!")
    add("jack", "I'd buy this startup!")
}

fun main(args: Array<String>) {
    println("Kwitter startup..")

    val server = Javalin.create()

    server.get("/ping") { ctx ->
        ctx.result("pong!".repeat(10))
    }

    server.get("/") { ctx ->
        ctx.json(db.all())
    }

    server.get("/web") { ctx ->
        ctx.html(indexPage(db))
    }

    server.get("/:kweetid") { ctx ->
        val kweetId = ctx.pathParam("kweetid").toInt()
        when(val kweet = db.getById(kweetId)) {
            null -> ctx.status(404).result("kweet #$kweetId is not found")
            else -> ctx.json(kweet)
        }
    }

    server.post("/") { ctx ->
        val req = ctx.body<NewKweet>()
        val kweet = db.add(req.handle, req.text)
        ctx.json(kweet)
    }

    server.get("/u/:handle") { ctx ->
        ctx.json(db.getByHandle(ctx.pathParam("handle")))
    }

    server.get("/search/:search") { ctx ->
        ctx.json(db.search(ctx.pathParam("search")))
    }

    server.start(7777)

}