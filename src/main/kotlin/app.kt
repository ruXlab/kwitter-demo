import io.javalin.Javalin

val db = KweetDb().apply {
    add("ruxmind", "my first kweet")
    add("ruxmind", "this is so fun")
    add("alice", "wow it's like kookge minus!")
    add("jack", "looks like an unicorn startup!")
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

    server.get("/:kweetid") { ctx ->
        val kweetId = ctx.pathParam("kweetid").toInt()
        when(val kweet = db.getById(kweetId)) {
            null -> ctx.status(404).result("kweet #$kweetId is not found")
            else -> ctx.json(kweet)
        }
    }

    server.start(7777)

}