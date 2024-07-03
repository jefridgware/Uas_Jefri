package com.example.myappgit.ui

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappgit.databinding.ActivityHistoryBinding
import historyAdapter

class historyActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IMAGE_BITMAP = "extra_image_bitmap"
        const val EXTRA_IMAGE_DESCRIPTION = "extra_image_description"
    }

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageBitmap = intent.getParcelableExtra<Bitmap>(EXTRA_IMAGE_BITMAP)
        val description = intent.getStringExtra(EXTRA_IMAGE_DESCRIPTION) ?: ""

        val capturedImage = CaptureImage(imageBitmap, description)
        val capturedImages = mutableListOf(capturedImage)
        val adapter = historyAdapter(capturedImages)
        binding.historyRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.historyRecyclerView.adapter = adapter
    }
}
