# kwitter-demo
Demo project for GDG Reading Meetup

### What is it?

It's a simple kwitter REST server - no ads, no registration, 
no UI, nothing really

It allows to list all kweets, retrieve by id, create, by user handle, search
and even view kweets in the browser in classy 1990 interface(no gifs tho) 

### How to start this thing?

Just run `./gradlew run`

### Created using

* kotlin 1.3.21
* javalin 2.6.0

### Useful commands (using [httpie](https://httpie.org/))

* Get all kweets - ```http :7777```
* Get kweet by id ```http :7777/3```
* Get [ruxmind](https://twitter.com/ruxmind)'s kweets - `http :7777/u/ruxmind`
* Post kweet `http POST :7777/ handle=ruxmind text="What a kool startup"`
* Search by text `http :7777/search/startup`

For simple web UI open [localhost:7777/web](http://localhost:7777/web)


### Links

* [Blog post for this presentation](https://rux.vc/2019.02/gdg-reading-meetup-reading-21-feb-2019/)
* [Author's blog](https://rux.vc/)
* [My twitter](https://twitter.com/ruxmind)
* [This demo project source code](https://github.com/ruXlab/kwitter-demo)
* [Event page at Meetup](https://www.meetup.com/GDG-Reading-Thames-Valley/events/258373119/)


