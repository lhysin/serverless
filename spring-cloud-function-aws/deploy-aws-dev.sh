#!/bin/bash -e

./gradlew clean && ./gradlew task build && sls deploy --stage dev