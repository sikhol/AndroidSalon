package com.kreasikode.muslimahsalon.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kreasikode.muslimahsalon.R;

public class ImageAdapter extends BaseAdapter {

    private int[] image_id = {R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa,R.drawable.spa};
    private String[] txt_layanan = {"SPA","Potong Rambut","Creambath","Facial","Perawatan Tubuh","Menicure","Pedicure","Smoothing","Hair Mask"};

    Context context;
    ImageAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return image_id.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View gridView = convertView;
        if (gridView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_image_layout,null);
        }

        ImageView imageView = gridView.findViewById(R.id.image_layanan);
        TextView textView = gridView.findViewById(R.id.txt_layanan);
        imageView.setImageResource(image_id[position]);
        textView.setText(txt_layanan[position]);

        return gridView;
    }
}
