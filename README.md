# cucumber-clj-example
Minimal example setup for building and running Cucumber features with step
definitions written in Clojure.

## Usage
Run the `cucumber` wrapper script from inside the project root:
```sh
./bin/cucumber
```

In order to change the output format or other runtime options adjust the
input parameters passed to the cli runner inside `features/support/runner.clj`.

---
(c) 2018 Tibor Claassen <tc@codebeige.net>
