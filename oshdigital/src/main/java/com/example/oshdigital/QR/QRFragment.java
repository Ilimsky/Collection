package com.example.oshdigital.QR;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oshdigital.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRFragment extends Fragment implements ZXingScannerView.ResultHandler{

    private static final String TAG = "QRScanner";
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private ZXingScannerView mScannerView;

    public QRFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qr, container, false);

        mScannerView = new ZXingScannerView(getActivity().getApplicationContext());
        //getActivity().setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
        mScannerView.resumeCameraPreview(this);

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        MY_CAMERA_REQUEST_CODE);
            }
        }
        return mScannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.d(TAG, "handleResult: " + result.getText());

        mScannerView.stopCameraPreview();

        String QRResult = result.getText();

        if (isParticipant(QRResult)) {
            Intent intent = new Intent(QRFragment.this.getActivity(), QRActivity.class);
            intent.putExtra("qr_result", QRResult);
            startActivity(intent);
            getActivity().finish();
        }
    }

    //TODO: check from the database whether the qr code is legit or not
    private boolean isParticipant(String userID) {
        return true;
    }
}


