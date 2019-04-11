package com.example.qr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class AfterActivity extends AppCompatActivity {

    private static final String TAG = "ParticipantConfirmation";
    private String participantID = "";
    private ImageView ivQRCode;
    private TextView tvParticipantName, tvParticipantID, tvHasConfirmed;
    private Button btnParticipantConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);

        participantID = getIntent().getStringExtra("qr_result");

        initView();
        generateQRCode(ivQRCode, participantID);

        //TODO: update textviews to participant data from database
        tvParticipantID.setText(participantID);
    }


    private void initView() {
        ivQRCode = findViewById(R.id.iv_qrcode);
        tvParticipantName = findViewById(R.id.tv_user_name);
        tvParticipantID = findViewById(R.id.tv_user_qr_code);
        tvHasConfirmed = findViewById(R.id.tv_has_confirmed);
        btnParticipantConfirmation = findViewById(R.id.btn_confirm_present);

        if (isConfirmed()) {
            tvHasConfirmed.setVisibility(View.VISIBLE);

            btnParticipantConfirmation.setText("Back");
            btnParticipantConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AfterActivity.this, MainActivity.class));
                    finish();
                }
            });
        } else {
            tvHasConfirmed.setVisibility(View.INVISIBLE);

            btnParticipantConfirmation.setText(R.string.confirmation_button);
            btnParticipantConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: checklist isPresent to user database, and then move back to mainactivity
                    startActivity(new Intent(AfterActivity.this, MainActivity.class));
                    Toast.makeText(AfterActivity.this, "Participant Successfully Confirmed", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }

    private void generateQRCode(ImageView display, String input) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(input, BarcodeFormat.QR_CODE, 500, 500);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            display.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private boolean isConfirmed() {
        //TODO: check if participant has confirmed before from database
        return true;
    }
}
