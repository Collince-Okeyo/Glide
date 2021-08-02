package com.ramgdeveloper.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ramgdeveloper.glide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Loading URL Image
        binding.buttonUrl.setOnClickListener {
            Glide.with(this)
                .load("data:image/jpeg;base64,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")
                .into(binding.imageView)
        }

        //Resizing image
        binding.buttonResize.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.image)
                .override(600,200)
                .into(binding.imageView)
        }

        //Scalling Image by Fitting Center
        binding.buttonScaling1.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.image)
                .fitCenter()
                .centerCrop()
                .into(binding.imageView)
        }

        //Scalling Image using Cropping
        binding.buttonScale2.setOnClickListener{
            Glide.with(this)
                .load(R.drawable.image)
                .centerCrop()
                .into(binding.imageView)
        }

        //Loading Drawable image

    }

    //
}