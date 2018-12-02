wget http://dl.google.com/android/android-sdk_r21.1-linux.tgz
tar xzf android-sdk_r21.1-linux.tgz
export ANDROID_HOME=$PWD/android-sdk-linux
export ANDROID_SDK_ROOT=$PWD/android-sdk-linux
export PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools