#!/usr/bin/env zsh

set -e
set -o pipefail
set -u
cd ../../..
gradle clean build --no-daemon --stacktrace --info --refresh-dependencies --warning-mode all --build-cache --parallel --continue --console=rich --scan