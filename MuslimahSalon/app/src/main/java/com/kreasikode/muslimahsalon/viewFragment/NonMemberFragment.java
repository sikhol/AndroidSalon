package com.kreasikode.muslimahsalon.viewFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.other.BottomSheetDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class NonMemberFragment extends Fragment implements View.OnClickListener{

    View v;
    private Button tambahLayanan;

    public NonMemberFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_non_member,container,false);
        tambahLayanan = v.findViewById(R.id.tambah_layanan);
        tambahLayanan.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tambah_layanan:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                assert getFragmentManager() != null;
                bottomSheetDialog.show(getFragmentManager(), "BottomSheet");
                break;
        }
    }
}
