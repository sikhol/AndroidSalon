package com.kreasikode.muslimahsalon.viewFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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
public class PendaftaranFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    View v;

    public PendaftaranFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pendaftaran,container,false);

        tabLayout = v.findViewById(R.id.tablayout_pendaftaran);
        viewPager = v.findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.AddFragment(new NonMemberFragment(),"Non Member");
        adapter.AddFragment(new MemberFragment(), "Member");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        return v;

    }

}
