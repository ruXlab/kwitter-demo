import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun indexPage(db: KweetDb) = createHTML().html {
    head {
        title { "Read only html interface for kwitter" }
        style { +"body { font-family: 'Mono' }" }
    }
    body {
        style = "padding: 3em"
        
        h1 {
            span {
                style = "color: red"
                +"K"
            }
            +"witter"
        }

        db.all().forEach { kweet ->
            div {
                b {
                    title = kweet.timestamp.toString()
                    +"@${kweet.handle}"
                }
                br {  }
                blockQuote { +kweet.text }
            }
        }
    }
}
