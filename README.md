# Pentago

This is a for-fun project using Boot and ClojureScript to make a
simple implementation of the game Pentago.

### Development

Run the development server with auto-compilation and auto-testing:

```
boot dev
```

See the results in your browser:

- App: [http://localhost:8080](http://localhost:8080)
- Devcards: [http://localhost:8080/devcards](http://localhost:8080/devcards)

You should see each update automatically if any HTML, styles or
ClojureScript files are changed on disk.

The `dev` build will start an `nREPL` server on a random port (which
it will print out). If you connect to that (with say `boot repl -c`),
and then run:


``` clojure
boot.user=> (start-repl)
```

Once you visit http://localhost:8080 you will have a browser-connected
ClojureScript REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.


### Release

Compile once using minification:

```
boot release
```

Assets will be in the `target` directory.

## License

Copyright © 2016 Geoff Shannon

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
