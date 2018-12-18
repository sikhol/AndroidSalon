package com.kreasikode.muslimahsalon.viewFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.other.ViewPagerAdapter;
import com.rahimlis.badgedtablayout.BadgedTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PembayaranFragment extends Fragment {

    private BadgedTabLayout tabLayoutBayar;
    private ViewPager viewPagerBayar;
    private View v;


    public PembayaranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_pembayaran,container,false);
        tabLayoutBayar = v.findViewById(R.id.tablayout_pembayaran);
        viewPagerBayar = v.findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.AddFragment(new ProsesFragment(),"Proses");
        adapter.AddFragment(new SelesaiFragment(), "Selesai");

        viewPagerBayar.setAdapter(adapter);
        tabLayoutBayar.setupWithViewPager(viewPagerBayar);

        tabLayoutBayar.setBadgeText(0,"6");
        tabLayoutBayar.setBadgeText(1,"0");

        return v;
    }

}
