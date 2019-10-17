cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
        ffmpeg-cmd

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ffmpeg_cmd.c
        ffmpeg/cmdutils.c
        ffmpeg/ffmpeg_filter.c
        ffmpeg/ffmpeg_opt.c
        ffmpeg/ffmpeg.c)

find_library(log-lib
        log)

#获取上级目录
get_filename_component(PARENT_DIR ${CMAKE_SOURCE_DIR} PATH)

add_library(ffmpeg-single
        SHARED
        IMPORTED)

set_target_properties(ffmpeg-single PROPERTIES IMPORTED_LOCATION ${PARENT_DIR}/jniLibs/${ANDROID_ABI}/libffmpeg.so)

#头文件
include_directories(include .)

target_link_libraries(ffmpeg-cmd ffmpeg-single ${log-lib})