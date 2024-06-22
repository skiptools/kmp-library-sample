#!/bin/bash
set -ex

./scripts/build.sh

gcpdw.vtag

LATEST_VERSION=$(git tag -l --sort=-version:refname | grep '[0-9]*\.[0-9]*\.[0-9]*' | head -n 1)

ARTIFACT="multi-platform-library/build/XCFrameworks/release/MultiPlatformLibrary.xcframework.zip"

gh release create --notes "$(cat ${ARTIFACT} | shasum -a 256)" ${LATEST_VERSION} ${ARTIFACT}

