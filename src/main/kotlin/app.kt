import io.javalin.Javalin

fun main(args: Array<String>) {
    println("Kwitter startup..")

    val server = Javalin.create()

    server.get("/ping") { ctx ->
        ctx.result("pong!".repeat(10))
    }

    server.start(7777)

}