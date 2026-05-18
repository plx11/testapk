#!/usr/bin/env bash
set -euo pipefail

SDK_ROOT="$HOME/android-sdk"
TOOLS_VERSION="13114758"
TOOLS_ZIP="commandlinetools-linux-${TOOLS_VERSION}_latest.zip"
TOOLS_URL="https://dl.google.com/android/repository/${TOOLS_ZIP}"

mkdir -p "$SDK_ROOT/cmdline-tools"

if [ ! -d "$SDK_ROOT/cmdline-tools/latest" ]; then
  cd "$SDK_ROOT/cmdline-tools"
  curl -fL -o "$TOOLS_ZIP" "$TOOLS_URL"
  rm -rf cmdline-tools latest
  unzip -q "$TOOLS_ZIP"
  mv cmdline-tools latest
fi

export ANDROID_SDK_ROOT="$SDK_ROOT"
export ANDROID_HOME="$SDK_ROOT"
export PATH="$PATH:$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$ANDROID_SDK_ROOT/platform-tools"

if ! grep -q "ANDROID_SDK_ROOT=$HOME/android-sdk" "$HOME/.bashrc"; then
  {
    echo 'export ANDROID_SDK_ROOT=$HOME/android-sdk'
    echo 'export ANDROID_HOME=$HOME/android-sdk'
    echo 'export PATH=$PATH:$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$ANDROID_SDK_ROOT/platform-tools'
  } >> "$HOME/.bashrc"
fi

yes | sdkmanager --licenses >/dev/null
sdkmanager "platform-tools" "platforms;android-35" "build-tools;35.0.0"

if [ -f /workspaces/testapk/local.properties ]; then
  sed -i '/^sdk\.dir=/d' /workspaces/testapk/local.properties
fi
echo "sdk.dir=$HOME/android-sdk" >> /workspaces/testapk/local.properties

echo "Android SDK setup complete at $SDK_ROOT"
