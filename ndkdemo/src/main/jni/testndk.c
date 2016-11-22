#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_demo_android_ndkdemo_TestNdk_getMessage(JNIEnv *env, jobject instance) {



    return (*env)->NewStringUTF(env, "hello jni");
}

