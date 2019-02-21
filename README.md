# kwitter-demo
Demo project for GDG Reading Meetup

Created using:

* kotlin 1.3.21
* javalin 2.6.0

### Useful commands (using [httpie](https://httpie.org/))

* Get all kweets - ```http :7777```
* Get kweet by id ```http :7777/3```
* Get [ruxmind](https://twitter.com/ruxmind)'s kweets - `http :7777/u/ruxmind`
* Post kweet `http POST :7777/ handle=ruxmind text="What a kool startup"`
* Search by text `http :7777/search/startup`

For simple web UI open [localhost:7777/web](http://localhost:7777/web)

