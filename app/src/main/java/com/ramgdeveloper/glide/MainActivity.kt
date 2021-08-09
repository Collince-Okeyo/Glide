package com.ramgdeveloper.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.ramgdeveloper.glide.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val resizeImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe0O0260hzKyKursZUTtZAxECP0gSVJ2JXwQ&usqp=CAU"
    private val image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5_f-3Npwnj40B6u8O8WmcX8swxRqUS8ncQg&usqp=CAU"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Loading URL Image
        binding.buttonUrl.setOnClickListener {
            Glide.with(this)
                .load(resizeImage)
                .into(binding.imageView)
        }
        //Resizing and fading an image
        binding.buttonResize.setOnClickListener {
            Glide.with(this)
                .load(resizeImage)
                .override(100, 50)
                .into(binding.imageView)
        }
        //FitCenter
        binding.buttonFitCenter.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.codingtable)
                .fitCenter()
                .into(binding.imageView)
        }
        //CenterCrop
        binding.buttonCenterCrop.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.codingtable)
                .centerCrop()
                .into(binding.imageView)
        }
        //CircleCrop
        binding.buttonCircleCrop.setOnClickListener {
            Glide.with(this)
                .load(image)
                .circleCrop()
                .into(binding.imageView)
        }
        //Loading Drawable image
        binding.buttonDrawable.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.image)
                .into(binding.imageView)
        }
        //PlaceHolder
        binding.buttonPlaceholder.setOnClickListener {
            Glide.with(this)
                .load(image)
                .placeholder(R.drawable.placeholder)
                .into(binding.imageView)
        }
        //Error
        binding.buttonError.setOnClickListener {
            Glide.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn")
                .error(R.drawable.error)
                .into(binding.imageView)
        }
        //Loading only from Cache
        binding.buttonCache.setOnClickListener {
            //DiskCache Strategy
            Glide.with(this)
                .load(resizeImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
            /*Glide.with(this)
                .load(resizeImage)
                .onlyRetrieveFromCache(true)
                .into(binding.imageView)*/
        }
        //Animated resources and custom Targets
        binding.buttonTarget.setOnClickListener {
            Glide.with(this)
                .asGif()
                .load(R.drawable.meditation)
                .into(object : SimpleTarget<GifDrawable>() {
                    override fun onResourceReady(
                        resource: GifDrawable,
                        transition: Transition<in GifDrawable>?
                    ) {
                        resource.start()
                        binding.imageView.setImageDrawable(resource)
                    }
                })
        }
    }
}