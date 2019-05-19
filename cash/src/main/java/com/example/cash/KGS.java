package com.example.cash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class KGS extends Fragment implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    public KGS() {
        // Required empty public constructor
    }

    Button btn5000, btn2000, btn1000, btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn3, btn1, btn050, btn010, btn001;
    EditText et5000, et2000, et1000, et500, et200, et100, et50, et20, et10, et5, et3, et1, et050, et010, et001;
    TextView tv5000, tv2000, tv1000, tv500, tv200, tv100, tv50, tv20, tv10, tv5, tv3, tv1, tv050, tv010, tv001, tvTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_kyrgyz, container, false);
        View view =  inflater.inflate(R.layout.fragment_kgs, container, false);

        btn5000 = view.findViewById(R.id.btn5000);
        et5000 = view.findViewById(R.id.et5000);
        tv5000 = view.findViewById(R.id.tv5000);
        btn5000.setOnClickListener(this);

        btn2000 = view.findViewById(R.id.btn2000);
        et2000 = view.findViewById(R.id.et2000);
        tv2000 = view.findViewById(R.id.tv2000);
        btn2000.setOnClickListener(this);

        btn1000 = view.findViewById(R.id.btn1000);
        et1000 = view.findViewById(R.id.et1000);
        tv1000 = view.findViewById(R.id.tv1000);
        btn1000.setOnClickListener(this);

        btn500 = view.findViewById(R.id.btn500);
        et500 = view.findViewById(R.id.et500);
        tv500 = view.findViewById(R.id.tv500);
        btn500.setOnClickListener(this);

        btn200 = view.findViewById(R.id.btn200);
        et200 = view.findViewById(R.id.et200);
        tv200 = view.findViewById(R.id.tv200);
        btn200.setOnClickListener(this);

        btn100 = view.findViewById(R.id.btn100);
        et100 = view.findViewById(R.id.et100);
        tv100 = view.findViewById(R.id.tv100);
        btn100.setOnClickListener(this);

        btn50 = view.findViewById(R.id.btn50);
        et50 = view.findViewById(R.id.et50);
        tv50 = view.findViewById(R.id.tv50);
        btn50.setOnClickListener(this);

        btn20 = view.findViewById(R.id.btn20);
        et20 = view.findViewById(R.id.et20);
        tv20 = view.findViewById(R.id.tv20);
        btn20.setOnClickListener(this);

        btn10 = view.findViewById(R.id.btn10);
        et10 = view.findViewById(R.id.et10);
        tv10 = view.findViewById(R.id.tv10);
        btn10.setOnClickListener(this);

        btn5 = view.findViewById(R.id.btn5);
        et5 = view.findViewById(R.id.et5);
        tv5 = view.findViewById(R.id.tv5);
        btn5.setOnClickListener(this);

        btn3 = view.findViewById(R.id.btn3);
        et3 = view.findViewById(R.id.et3);
        tv3 = view.findViewById(R.id.tv3);
        btn3.setOnClickListener(this);

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
        int num5000, num2000, num1000, num500, num200,num100,num50,num20,num10,num5,num3,num1;
        int result5000, result2000, result1000, result500, result200, result100, result50, result20, result10, result5, result3, result1;

        double num050, num010, num001;
        double result050, result010, result001, resultTotal;

        num5000 = Integer.parseInt(et5000.getText().toString());
        result5000 = 5000 * num5000;
        resultTotal = result5000;
        tv5000.setText(" " + result5000);
        tvTotal.setText(" " + resultTotal);

        num2000 = Integer.parseInt(et2000.getText().toString());
        result2000 = 2000 * num2000;
        resultTotal = result2000;
        tv2000.setText(" " + result2000);
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

        num200 = Integer.parseInt(et200.getText().toString());
        result200 = 200*num200;
        resultTotal = result5000 + result1000 + result500 + result200;
        tv200.setText(" " + result200);
        tvTotal.setText(" " + resultTotal);

        num100 = Integer.parseInt(et100.getText().toString());
        result100 = 100*num100;
        resultTotal = result5000 + result1000 + result500 + result200 + result100;
        tv100.setText(" " + result100);
        tvTotal.setText(" " + resultTotal);

        num50 = Integer.parseInt(et50.getText().toString());
        result50 = 50*num50;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50;
        tv50.setText(" " + result50);
        tvTotal.setText(" " + resultTotal);

        num20 = Integer.parseInt(et20.getText().toString());
        result20 = 20*num20;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20;
        tv20.setText(" " + result20);
        tvTotal.setText(" " + resultTotal);

        num10 = Integer.parseInt(et10.getText().toString());
        result10 = 10*num10;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10;
        tv10.setText(" " + result10);
        tvTotal.setText(" " + resultTotal);

        num5 = Integer.parseInt(et5.getText().toString());
        result5 = 5*num5;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5;
        tv5.setText(" " + result5);
        tvTotal.setText(" " + resultTotal);

        num3 = Integer.parseInt(et3.getText().toString());
        result3 = 3*num3;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5 + result3;
        tv3.setText(" " + result3);
        tvTotal.setText(" " + resultTotal);

        num1 = Integer.parseInt(et1.getText().toString());
        result1 = 1*num1;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5 + result3 + result1;
        tv1.setText(" " + result1);
        tvTotal.setText(" " + resultTotal);

        num050 = Integer.parseInt(et050.getText().toString());
        result050 = 0.5*num050;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5 + result3 + result1 + result050;
        tv050.setText(" " + Math.round(result050*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num010 = Integer.parseInt(et010.getText().toString());
        result010 = 0.1*num010;
        resultTotal = result5000 + result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5 + result3 + result1 + result050 + result010;
        tv010.setText(" " + Math.round(result010*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num001 = Integer.parseInt(et001.getText().toString());
        result001 = 0.01*num001;
        resultTotal = result5000+ result1000 + result500 + result200 + result100 + result50 + result20 + result10 + result5 + result3 + result1 + result050 + result010 + result001;
        tv001.setText(" " + Math.round(result001*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                et5000.setText("0");
                et2000.setText("0");
                tv5000.setText("");
                et1000.setText("0");
                tv1000.setText("");
                et500.setText("0");
                tv500.setText("");
                et200.setText("0");
                tv200.setText("");
                et100.setText("0");
                tv100.setText("");
                et50.setText("0");
                tv50.setText("");
                et20.setText("0");
                tv20.setText("");
                et10.setText("0");
                tv10.setText("");
                et5.setText("0");
                tv5.setText("");
                et3.setText("0");
                tv3.setText("");
                et1.setText("0");
                tv1.setText("");
                et050.setText("0");
                tv050.setText("");
                et010.setText("0");
                tv010.setText("");
                et001.setText("0");
                tv001.setText("");
                tvTotal.setText("Жалпы");
                break;
            }
        return super.onOptionsItemSelected(item);
    }
}
