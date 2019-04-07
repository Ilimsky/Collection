package com.example.traveldirectory.D;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traveldirectory.Basic.OnBackPressedListener;
import com.example.traveldirectory.R;

import ru.aviasales.core.AviasalesSDK;
import ru.aviasales.core.identification.SdkConfig;
import ru.aviasales.template.ui.fragment.AviasalesFragment;

public class DFragment extends Fragment implements OnBackPressedListener {
    // replace with your travel payout credentials
    private final static String TRAVEL_PAYOUTS_MARKER = "173030";
    private final static String TRAVEL_PAYOUTS_TOKEN = "d9a8e1889d57ab46c9476061ca5eeabf";
    private final static String SDK_HOST = "www.travel-api.pw";
    private AviasalesFragment aviasalesFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_d, container, false);
        AviasalesSDK.getInstance().init(this.getContext(), new SdkConfig(TRAVEL_PAYOUTS_MARKER, TRAVEL_PAYOUTS_TOKEN, SDK_HOST));
        init();
        return rootView;
    }

    private void init() {
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getFragmentManager();
        aviasalesFragment = (AviasalesFragment) fm.findFragmentByTag(AviasalesFragment.TAG);

        if (aviasalesFragment == null) {
            aviasalesFragment = (AviasalesFragment) AviasalesFragment.newInstance();
        }

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, aviasalesFragment, AviasalesFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (!aviasalesFragment.onBackPressed()) {
            super.getActivity().onBackPressed();
        }
    }
}
