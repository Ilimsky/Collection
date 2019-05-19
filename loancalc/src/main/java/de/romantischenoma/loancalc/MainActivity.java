package de.romantischenoma.loancalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewSchedule;
    EditText editTextLoanSum, editTextLoanTerm, editTextLoanRate;
    Button buttonClear, buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSchedule = (TextView) findViewById(R.id.tv_schedule);
        textViewSchedule.setMovementMethod(new ScrollingMovementMethod());

        editTextLoanSum = (EditText) findViewById(R.id.et_loan_sum);
        editTextLoanTerm = (EditText) findViewById(R.id.et_loan_term);
        editTextLoanRate = (EditText) findViewById(R.id.et_loan_rate);
        buttonClear = (Button) findViewById(R.id.btn_clear);
        buttonCalculate = (Button) findViewById(R.id.btn_calculate);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSchedule.setText("");
                editTextLoanSum.setText("0");
                editTextLoanTerm.setText("0");
                editTextLoanRate.setText("0");
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loanCalc();
            }
        });


    }

    void loanCalc(){
        int LoanSum, LoanTerm;
        double LoanRate;

        LoanSum = Integer.parseInt(editTextLoanSum.getText().toString());
        LoanTerm = Integer.parseInt(editTextLoanTerm.getText().toString());
        LoanRate = Double.parseDouble(editTextLoanRate.getText().toString());

        double schedulePayment = (((LoanRate / 1200 * (Math.pow((1 + LoanRate / 1200), LoanTerm))) //Формула аннуитета
                / (Math.pow((1 + LoanRate / 1200), LoanTerm) - 1)) * LoanSum);
        double scheduleResidue = (LoanSum - (schedulePayment - (LoanSum*LoanRate/1200)));
        double scheduleRate = LoanSum*LoanRate/1200;
        double scheduleCapital = schedulePayment - scheduleRate;
        double a;

        textViewSchedule.append(String.format("%s %15s %15s %15s %15s %n" , "№", "Взнос", "Проценты", "Капитал", "Остаток"));
        for (int i = 1; i < LoanTerm; i++){
            if (i<10){
                textViewSchedule.append(String.format("%3d %15.2f %15.2f %15.2f %15.2f %n", i, schedulePayment, scheduleRate,
                        scheduleCapital, scheduleResidue));
            } else {
                textViewSchedule.append(String.format("%d %15.2f %15.2f %15.2f %15.2f %n", i, schedulePayment, scheduleRate,
                        scheduleCapital, scheduleResidue));
            }
            scheduleRate = (scheduleResidue * (LoanRate/1200));
            scheduleCapital = schedulePayment - scheduleRate;
            scheduleResidue = scheduleResidue - scheduleCapital;
        }

        textViewSchedule.append(String.format("%d %15.2f %15.2f %15.2f %15s %n", LoanTerm, scheduleRate + scheduleCapital + scheduleResidue,
                scheduleRate, scheduleCapital + scheduleResidue, "0"));

        a = (schedulePayment*(LoanTerm-1)+scheduleRate + scheduleCapital + scheduleResidue) - LoanSum;

        textViewSchedule.append(String.format("%20.2f %15.2f %15.2f",
                schedulePayment*LoanTerm,
                a,
                schedulePayment*LoanTerm - a));
    }
}
