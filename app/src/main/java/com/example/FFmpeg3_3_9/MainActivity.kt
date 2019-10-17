package com.example.FFmpeg3_3_9

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ffmpegCmd = FFmpegCmd()
        // Example of a call to a native method
        sample_text.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
                return@setOnClickListener
            }
            val base = Environment.getExternalStorageDirectory().path

            val commands = arrayOfNulls<String>(4)

            commands[0] = "ffmpeg"

            //输入

            commands[1] = "-i"

            commands[2] = "$base/input.mp4"

            commands[3] = "$base/merge.gif"

            ffmpegCmd.exec(commands)
            Toast.makeText(this@MainActivity, "命令执行完成", Toast.LENGTH_SHORT).show()
        }
    }


}
