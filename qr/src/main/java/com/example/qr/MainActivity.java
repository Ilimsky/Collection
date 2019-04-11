package com.example.qr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final String TAG = "QRScanner";
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        MY_CAMERA_REQUEST_CODE);
            }
        }

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

    public void handleResult(Result rawResult) {
        Log.d(TAG, "handleResult: " + rawResult.getText());

        mScannerView.stopCameraPreview();

        String QRResult = rawResult.getText();

        if (isParticipant(QRResult)) {
            Intent toConfirmationActivity = new Intent(MainActivity.this, AfterActivity.class);
            toConfirmationActivity.putExtra("qr_result", QRResult);
            startActivity(toConfirmationActivity);
            finish();
        }
    }

    //TODO: check from the database whether the qr code is legit or not
    private boolean isParticipant(String userID) {
        return true;
    }


}
