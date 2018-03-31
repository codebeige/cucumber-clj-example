(-> ["--plugin" "progress" "--glue" "features/step_definitions" "features"]
    into-array
    cucumber.api.cli.Main/main)
