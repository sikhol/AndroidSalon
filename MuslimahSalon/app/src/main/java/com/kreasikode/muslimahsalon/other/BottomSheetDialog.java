package com.kreasikode.muslimahsalon.other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;

import com.kreasikode.muslimahsalon.R;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private GridView gridView;
//    private int count;
//    private Bitmap[] thumbnails;
//    private boolean[] thumbnailsselection;
//    private String[] arrPath;
//    private ImageAdapter imageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        gridView = v.findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(getContext());
        gridView.setAdapter(imageAdapter);
        return v;
    }

//    public class ImageAdapter extends BaseAdapter {
//        private LayoutInflater mInflater;
//
//        public ImageAdapter() {
//            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public Object getItem(int position) {
//            return position;
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder holder;
//            if (convertView == null) {
//                holder = new ViewHolder();
//                convertView = mInflater.inflate(R.layout.custom_image_layout, null);
//                holder.imageview = (ImageView) convertView.findViewById(R.id.image_layanan);
//                holder.checkbox = (CheckBox) convertView.findViewById(R.id.itemCheckBox);
//
//                convertView.setTag(holder);
//            }
//            else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.checkbox.setId(position);
//            holder.imageview.setId(position);
//            holder.checkbox.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    CheckBox cb = (CheckBox) v;
//                    int id = cb.getId();
//                    if (thumbnailsselection[id]){
//                        cb.setChecked(false);
//                        thumbnailsselection[id] = false;
//                    } else {
//                        cb.setChecked(true);
//                        thumbnailsselection[id] = true;
//                    }
//                }
//            });
//            holder.imageview.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    int id = v.getId();
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.setDataAndType();
//                    startActivity(intent);
//                }
//            });
//            holder.imageview.setImageBitmap(thumbnails[position]);
//            holder.checkbox.setChecked(thumbnailsselection[position]);
//            holder.id = position;
//            return convertView;
//        }
//    }
//    class ViewHolder {
//        ImageView imageview;
//        CheckBox checkbox;
//        int id;
//    }

}
