
package de.romantischenoma.banknotecalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class RUR extends Fragment implements View.OnClickListener {

    public RUR() {
        // Required empty public constructor
    }

    Button btn5000, btn1000, btn500, btn100, btn50, btn10, btn5, btn2, btn1, btn050, btn010, btn005, btn001;
    EditText et5000, et1000, et500, et100, et50, et10, et5, et2, et1, et050, et010, et005, et001;
    TextView tv5000, tv1000, tv500, tv100, tv50, tv10, tv5, tv2, tv1, tv050, tv010, tv005, tv001, tvTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_kyrgyz, container, false);
        View view =  inflater.inflate(R.layout.fragment_rur, container, false);

        btn5000 = view.findViewById(R.id.btn5000);
        et5000 = view.findViewById(R.id.et5000);
        tv5000 = view.findViewById(R.id.tv5000);
        btn5000.setOnClickListener(this);

        btn1000 = view.findViewById(R.id.btn1000);
        et1000 = view.findViewById(R.id.et1000);
        tv1000 = view.findViewById(R.id.tv1000);
        btn1000.setOnClickListener(this);

        btn500 = view.findViewById(R.id.btn500);
        et500 = view.findViewById(R.id.et500);
        tv500 = view.findViewById(R.id.tv500);
        btn500.setOnClickListener(this);

        btn100 = view.findViewById(R.id.btn100);
        et100 = view.findViewById(R.id.et100);
        tv100 = view.findViewById(R.id.tv100);
        btn100.setOnClickListener(this);

        btn50 = view.findViewById(R.id.btn50);
        et50 = view.findViewById(R.id.et50);
        tv50 = view.findViewById(R.id.tv50);
        btn50.setOnClickListener(this);

        btn10 = view.findViewById(R.id.btn10);
        et10 = view.findViewById(R.id.et10);
        tv10 = view.findViewById(R.id.tv10);
        btn10.setOnClickListener(this);

        btn5 = view.findViewById(R.id.btn5);
        et5 = view.findViewById(R.id.et5);
        tv5 = view.findViewById(R.id.tv5);
        btn5.setOnClickListener(this);

        btn2 = view.findViewById(R.id.btn2);
        et2 = view.findViewById(R.id.et2);
        tv2 = view.findViewById(R.id.tv2);
        btn2.setOnClickListener(this);

        btn1 = view.findViewById(R.id.btn1);
        et1 = view.findViewById(R.id.et1);
        tv1 = view.findViewById(R.id.tv1);
        btn1.setOnClickListener(this);

        btn050 = view.findViewById(R.id.btn050);
        et050 = view.findViewById(R.id.et050);
        tv050 = view.findViewById(R.id.tv050);
        btn050.setOnClickListener(this);

        btn010 = view.findViewById(R.id.btn010);
        et010 = view.findViewById(R.id.et010);
        tv010 = view.findViewById(R.id.tv010);
        btn010.setOnClickListener(this);

        btn005 = view.findViewById(R.id.btn005);
        et005 = view.findViewById(R.id.et005);
        tv005 = view.findViewById(R.id.tv005);
        btn005.setOnClickListener(this);

        btn001 = view.findViewById(R.id.btn001);
        et001 = view.findViewById(R.id.et001);
        tv001 = view.findViewById(R.id.tv001);
        btn001.setOnClickListener(this);

        tvTotal = view.findViewById(R.id.tvTotal);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int num5000, num1000, num500, num100, num50, num10, num5, num2, num1;
        int result5000, result1000, result500, result100, result50, result10, result5, result2, result1;

        double num050, num010, num005, num001;
        double result050, result010, result005, result001, resultTotal;

        num5000 = Integer.parseInt(et5000.getText().toString());
        result5000 = 5000 * num5000;
        resultTotal = result5000;
        tv5000.setText(" " + result5000);
        tvTotal.setText(" " + resultTotal);

        num1000 = Integer.parseInt(et1000.getText().toString());
        result1000 = 1000*num1000;
        resultTotal = result5000 + result1000;
        tv1000.setText(" " + result1000);
        tvTotal.setText(" " + resultTotal);

        num500 = Integer.parseInt(et500.getText().toString());
        result500 = 500*num500;
        resultTotal = result5000 + result1000 + result500;
        tv500.setText(" " + result500);
        tvTotal.setText(" " + resultTotal);

        num100 = Integer.parseInt(et100.getText().toString());
        result100 = 100*num100;
        resultTotal = result5000 + result1000 + result500 + result100;
        tv100.setText(" " + result100);
        tvTotal.setText(" " + resultTotal);

        num50 = Integer.parseInt(et50.getText().toString());
        result50 = 50*num50;
        resultTotal = result5000 + result1000 + result500 + result100 + result50;
        tv50.setText(" " + result50);
        tvTotal.setText(" " + resultTotal);

        num10 = Integer.parseInt(et10.getText().toString());
        result10 = 10*num10;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10;
        tv10.setText(" " + result10);
        tvTotal.setText(" " + resultTotal);

        num5 = Integer.parseInt(et5.getText().toString());
        result5 = 5*num5;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5;
        tv5.setText(" " + result5);
        tvTotal.setText(" " + resultTotal);

        num2 = Integer.parseInt(et2.getText().toString());
        result2 = 2*num2;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result2;
        tv2.setText(" " + result2);
        tvTotal.setText(" " + resultTotal);

        num1 = Integer.parseInt(et1.getText().toString());
        result1 = 1*num1;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result1;
        tv1.setText(" " + result1);
        tvTotal.setText(" " + resultTotal);

        num050 = Integer.parseInt(et050.getText().toString());
        result050 = 0.5*num050;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result1 + result050;
        tv050.setText(" " + Math.round(result050*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num010 = Integer.parseInt(et010.getText().toString());
        result010 = 0.1*num010;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result1 + result050 + result010;
        tv010.setText(" " + Math.round(result010*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num005 = Integer.parseInt(et005.getText().toString());
        result005 = 0.05*num005;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result1 + result050 + result010 + result005;
        tv005.setText(" " + Math.round(result005*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);

        num001 = Integer.parseInt(et001.getText().toString());
        result001 = 0.01*num001;
        resultTotal = result5000 + result1000 + result500 + result100 + result50 + result10 + result5 + result1 + result050 + result010 + result005 + result001;
        tv001.setText(" " + Math.round(result001*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);

        tvTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et5000.setText("0");
                tv5000.setText("");
                et1000.setText("0");
                tv1000.setText("");
                et500.setText("0");
                tv500.setText("");
                et100.setText("0");
                tv100.setText("");
                et50.setText("0");
                tv50.setText("");
                et10.setText("0");
                tv10.setText("");
                et5.setText("0");
                tv5.setText("");
                et2.setText("0");
                tv2.setText("");
                et1.setText("0");
                tv1.setText("");
                et050.setText("0");
                tv050.setText("");
                et010.setText("0");
                tv010.setText("");
                et005.setText("0");
                tv005.setText("");
                tvTotal.setText("Для очистки нажмите здесь");
            }
        });
    }
}

