#!/usr/bin/env bash

cd ../vv-viamais-android-app-vendedor
git pull
./gradlew assembleHomolog
cd ../vv-viamais-qa
cp ../vv-viamais-android-app-vendedor/app/build/outputs/apk/homolog/app-homolog.apk artifacts/app-ViaMais.apk
