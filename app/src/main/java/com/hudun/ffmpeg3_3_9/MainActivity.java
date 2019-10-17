package com.hudun.ffmpeg3_3_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FFmpeg3_3_9.R;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeg-cmd");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FFmpegCmd fFmpegCmd = new FFmpegCmd();
        // Example of a call to a native method
         findViewById(R.id.sample_text).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String base = Environment.getExternalStorageDirectory().getPath();


                 String[] commands =new String[4];

                 commands[0] ="ffmpeg";

                 //输入

                 commands[1] ="-i";

                 commands[2] = base +"/input.mp4";

//                 //水印
//
//                 commands[3] ="-i";
//
//                 commands[4] = base +"/ic_launcher.png";//此处的图片地址换成带透明通道的视频就可以合成动态视频遮罩。
//
//                 commands[5] ="-filter_complex";
//
//                 commands[6] ="[1:v]scale=300:300[s];[0:v][s]overlay=50:10";
//
//                 //覆盖输出
//
//                 commands[7] ="-y";//直接覆盖输出文件
//
////输出文件

                 commands[3] = base +"/merge.gif";

                 fFmpegCmd.exec(commands.length,commands);
                 Toast.makeText(MainActivity.this, "命令执行完成", Toast.LENGTH_SHORT).show();
             }
         });
    }
}
