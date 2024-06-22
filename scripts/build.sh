#!/bin/sh
set -ex

gradle assembleMultiPlatformLibraryXCFramework

cd mpp-library/build/XCFrameworks/release/

rm -f MultiPlatformLibrary.xcframework.zip
zip -r MultiPlatformLibrary.xcframework.zip MultiPlatformLibrary.xcframework
ls -lah MultiPlatformLibrary.xcframework.zip
shasum -a 256 MultiPlatformLibrary.xcframework.zip

