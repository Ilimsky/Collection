package com.example.effectiveinterestrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvPayment, tvAmount, tvInterestRate;
    EditText edLoanSum, edLoanTerm, edLoanRate, edLoanCommission, edCashingOut, edTax;
    Button btnClear, btnCalculate, btnSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLoanSum = findViewById(R.id.editTextLoanSum);
        edLoanTerm = findViewById(R.id.editTextLoanTerm);
        edLoanRate = findViewById(R.id.editTextLoanRate);
        edLoanCommission = findViewById(R.id.editTextLoanCommission);
        edCashingOut = findViewById(R.id.editTextCashingOut);
        edTax = findViewById(R.id.editTextTax);
        btnClear = findViewById(R.id.buttonClear);
        btnCalculate = findViewById(R.id.buttonCalculate);
        btnSchedule = findViewById(R.id.buttonSchedule);
        tvPayment = findViewById(R.id.textViewPayment);
        tvAmount = findViewById(R.id.textViewAmount);
        tvInterestRate = findViewById(R.id.textViewInterestRate);



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edLoanSum.setText("0");
                edLoanTerm.setText("0");
                edLoanRate.setText("0");
                edLoanCommission.setText("0");
                edCashingOut.setText("0");
                edTax.setText("0");
                tvPayment.setText("0");
                tvAmount.setText("0");
                tvInterestRate.setText("0");
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int LoanSum, LoanTerm;
                double LoanRate;

                LoanSum = Integer.parseInt(edLoanSum.getText().toString());
                LoanTerm = Integer.parseInt(edLoanTerm.getText().toString());
                LoanRate = Double.parseDouble(edLoanRate.getText().toString());

                double payment = (((LoanRate / 1200 * (Math.pow((1 + LoanRate / 1200), LoanTerm))) //Формула аннуитета
                        / (Math.pow((1 + LoanRate / 1200), LoanTerm) - 1)) * LoanSum);

                tvPayment.setText(new DecimalFormat("##.##").format(payment));
            }
        });

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                intent.putExtra("LoanSum", edLoanSum.getText().toString());
                intent.putExtra("loanTerm", edLoanTerm.getText().toString());
                intent.putExtra("LoanRate", edLoanRate.getText().toString());
                intent.putExtra("LoanCommission", edLoanCommission.getText().toString());
                intent.putExtra("LoanCashingOut", edCashingOut.getText().toString());
                intent.putExtra("LoanTax", edTax.getText().toString());
                intent.putExtra("LoanPayment", tvPayment.getText().toString());
                startActivity(intent);
            }
        });
    }
}
