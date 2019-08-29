package com.hudun.ffmpeg3_3_9;

/**
 * Author:     zhangguoliang
 * CreateDate: 2019/8/22 15:09
 */
public class FFmpegCmd {

    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeg-cmd");
    }

    public native int exec(int argc, String[] argv);

}
