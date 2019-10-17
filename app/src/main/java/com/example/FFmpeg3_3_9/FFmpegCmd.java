package com.example.FFmpeg3_3_9;

public class FFmpegCmd {
    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeg-cmd");
    }
    public native int exec( String[] argv);
}
