package com.example.effectiveinterestrate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ScheduleActivity extends AppCompatActivity {

    TextView textView;
    //DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        textView = findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String stringLoanSum = intent.getStringExtra("LoanSum");
        double loanSum = Double.parseDouble(stringLoanSum);

        String stringLoanTerm = intent.getStringExtra("loanTerm");
        int loanTerm = Integer.parseInt(stringLoanTerm);

        String stringLoanRate = intent.getStringExtra("LoanRate");
        double loanRate = Double.parseDouble(stringLoanRate);

        String stringLoanTax = intent.getStringExtra("LoanTax");
        double loanTax = Double.parseDouble(stringLoanTax);

        String stringLoanCommission = intent.getStringExtra("LoanCommission");
        double loanCommission = Double.parseDouble(stringLoanCommission);

        String stringCashingOut = intent.getStringExtra("LoanCashingOut");
        double loanCashingOut = Double.parseDouble(stringCashingOut);

        String stringPayment = intent.getStringExtra("LoanPayment");
        double schedulePayment = Double.parseDouble(stringPayment);

        double scheduleResidue = (loanSum - (schedulePayment - (loanSum*loanRate/1200)));
        double scheduleRate = loanSum*loanRate/1200;
        double scheduleCapital = schedulePayment - scheduleRate;
        double a;

        textView.append(String.format("%s %15.2f %n" , "Комиссия по кредиту = ", loanSum*loanCommission/100));
        textView.append(String.format("%s %15.2f %n" , "Обналичивание = ", loanSum*loanCashingOut/100));

        textView.append(String.format("%s %15s %15s %15s %15s %15s %15s %n" , "№", "Взнос", "Проценты", "Капитал", "Остаток", "Налог с продаж", "ЭПС"));
        for (int i = 1; i < loanTerm; i++){
            if (i<10){
                textView.append(String.format("%3d %15.2f %15.2f %15.2f %15.2f %15.2f %n", i, schedulePayment, scheduleRate,
                        scheduleCapital, scheduleResidue, scheduleRate*loanTax/100));
            } else {
                textView.append(String.format("%d %15.2f %15.2f %15.2f %15.2f %15.2f %n", i, schedulePayment, scheduleRate,
                        scheduleCapital, scheduleResidue, scheduleRate*loanTax/100));
            }
            scheduleRate = (scheduleResidue * (loanRate/1200));
            scheduleCapital = schedulePayment - scheduleRate;
            scheduleResidue = scheduleResidue - scheduleCapital;
        }

        textView.append(String.format("%d %15.2f %15.2f %15.2f %15s %24.2f %n", loanTerm, scheduleRate + scheduleCapital + scheduleResidue,
                scheduleRate, scheduleCapital + scheduleResidue, "0", scheduleRate*loanTax/100));

        a = (schedulePayment*(loanTerm-1)+scheduleRate + scheduleCapital + scheduleResidue)-loanSum;
        textView.append(String.format("%15.2f %15.2f %15.2f %15s %15.2f %15.2f",
                schedulePayment*(loanTerm-1)+scheduleRate + scheduleCapital + scheduleResidue,
                a,
                loanSum,
                " ",
                a*loanTax/100,
                (a + a*loanTax/100 + loanSum*loanCommission/100 + loanSum*loanCashingOut/100)/loanSum*100));

    }
}
