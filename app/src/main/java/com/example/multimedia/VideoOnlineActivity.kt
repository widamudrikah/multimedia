package com.example.multimedia

import android.app.ProgressDialog
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import com.example.multimedia.databinding.ActivityVideoOnlineBinding

class VideoOnlineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoOnlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoOnlineBinding.inflate(layoutInflater)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(binding.root)


        supportActionBar?.hide()

        val urlVideo = Uri.parse("https://bit.ly/3MiAKDX")


        val controller = MediaController(this)
        controller.setAnchorView(binding.videoOnlineView)
        binding.videoOnlineView.setMediaController(controller)

//        val loading = ProgressDialog(this)
//        loading.setMessage("Loading...")
//        loading.show()

        val load = setProgressDialog(this, "Sabar gaes...")
        load.show()

        binding.videoOnlineView.setVideoURI(urlVideo)
        binding.videoOnlineView.requestFocus()
        binding.videoOnlineView.setOnCompletionListener {
            it.start()
            load.dismiss()
        }
    }
}