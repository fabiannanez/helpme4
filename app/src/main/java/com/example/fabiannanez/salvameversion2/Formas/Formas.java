package com.example.fabiannanez.salvameversion2.Formas;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


/**
 * Created by fabiannanez on 30/05/2016.
 */
public class Formas {

    private static Transformation transformation = new RoundedTransformationBuilder()
            .scaleType(ImageView.ScaleType.CENTER_CROP)
            .oval(true)
            .build();

    @BindingAdapter("app:imgCircleUrl")
    public static void loadCircleImage(ImageView view, String url){
        Uri uri = Uri.parse(url);
        int size =  view.getLayoutParams().width;
        Picasso.with(view.getContext()).load(uri).resize(size, size)
                .centerCrop()
                .transform(transformation).into(view);
    }


}
