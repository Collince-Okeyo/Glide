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
    private val resizeImage =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe0O0260hzKyKursZUTtZAxECP0gSVJ2JXwQ&usqp=CAU"
    private val image =
        "data:image/jpeg;base64,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"

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
        binding.buttonScaling1.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.codingtable)
                .fitCenter()
                .into(binding.imageView)
        }
        //CenterCrop
        binding.buttonScale2.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.codingtable)
                .centerCrop()
                .into(binding.imageView)
        }
        //CircleCrop
        binding.buttonCircular.setOnClickListener {
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