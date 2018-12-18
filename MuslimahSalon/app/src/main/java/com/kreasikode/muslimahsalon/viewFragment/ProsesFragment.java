package com.kreasikode.muslimahsalon.viewFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.view.UpdateDataPembayaranActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProsesFragment extends Fragment {

    private View v;
    private CardView cardView;

    public ProsesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_proses,container,false);
        cardView = v.findViewById(R.id.card1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailbayar = new Intent(getActivity(), UpdateDataPembayaranActivity.class);
                startActivity(detailbayar);
            }
        });
        return v;
    }

}
