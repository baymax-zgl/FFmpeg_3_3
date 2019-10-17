//
// Created by Administrator on 2019/8/22.
//
#include <jni.h>
#include <stdio.h>
#include <time.h>
#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"
#include "libavfilter/avfilter.h"
#include "libavutil/log.h"

#include <android/log.h>
#include <ffmpeg/android_log.h>
#include <ffmpeg/ffmpeg.h>



JNIEXPORT jint JNICALL Java_com_example_FFmpeg3_13_19_FFmpegCmd_exec
        (JNIEnv *env, jobject instance,jobjectArray commands) {

    //获取数组长度
    int argc = (*env)->GetArrayLength(env, commands);
    char *argv[argc];
    int i;
    //循环遍历数组，组合成相应的/、字符串
    for (i = 0; i < argc; i++) {
        jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
        argv[i] = (char *) (*env)->GetStringUTFChars(env, js, 0);
    }
    LOGD("----------begin---------");
    return cmd_exec(argc, argv);
}
