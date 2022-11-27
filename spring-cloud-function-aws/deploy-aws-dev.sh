#!/bin/bash -e

./gradlew clean && ./gradlew buildZip && sls deploy --stage dev