# cucumber-clj-example
Minimal example setup for building and running [Cucumber] features with step
definitions written in [Clojure].

## Prerequisites

The [Clojure CLI tools] need to be installed. Please refer to the
[Getting Started Guide] for instructions.

## Usage

Run the `cucumber` wrapper script from inside the project root:
```sh
bin/cucumber
```

In order to change the output format or other runtime options adjust the
input parameters passed to the CLI runner inside `features/support/runner.clj`.

---
(c) 2018 Tibor Claassen <tc@codebeige.net>

[Clojure CLI tools]: https://clojure.org/guides/deps_and_cli
[Clojure]: https://clojure.org
[Cucumber]: https://cucumber.io
[Getting Started Guide]: https://clojure.org/guides/getting_started
