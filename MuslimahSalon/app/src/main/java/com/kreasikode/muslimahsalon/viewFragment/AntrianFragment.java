package com.kreasikode.muslimahsalon.viewFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.view.MenuActivity;
import com.kreasikode.muslimahsalon.view.UpdateDataAntrianActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AntrianFragment extends Fragment {


    private CardView cardView;

    public AntrianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_antrian, container, false);
        cardView = v.findViewById(R.id.card1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ubahintent = new Intent(getActivity(), UpdateDataAntrianActivity.class);
                startActivity(ubahintent);
            }
        });

        return v;
    }

}
