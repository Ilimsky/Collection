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
public class USD extends Fragment implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    public USD() {
        // Required empty public constructor
    }

    Button btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn025, btn010, btn005, btn001;
    EditText et100, et50, et20, et10, et5, et2, et1, et050, et025, et010, et005, et001;
    TextView tv100, tv50, tv20, tv10, tv5, tv2, tv1, tv050, tv025, tv010, tv005, tv001, tvTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_kyrgyz, container, false);
        View view =  inflater.inflate(R.layout.fragment_usd, container, false);

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

        btn025 = view.findViewById(R.id.btn025);
        et025 = view.findViewById(R.id.et025);
        tv025 = view.findViewById(R.id.tv025);
        btn025.setOnClickListener(this);

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
        int num100, num50, num20, num10, num5,num2, num1;
        int result100, result50, result20, result10, result5, result2, result1;

        double num050, num025, num010, num005, num001;
        double result050, result025, result010, result005, result001, resultTotal;

        num100 = Integer.parseInt(et100.getText().toString());
        result100 = 100*num100;
        resultTotal = result100;
        tv100.setText(" " + result100);
        tvTotal.setText(" " + resultTotal);

        num50 = Integer.parseInt(et50.getText().toString());
        result50 = 50*num50;
        resultTotal = result100 + result50;
        tv50.setText(" " + result50);
        tvTotal.setText(" " + resultTotal);

        num20 = Integer.parseInt(et20.getText().toString());
        result20 = 20*num20;
        resultTotal = result100 + result50 + result20;
        tv20.setText(" " + result20);
        tvTotal.setText(" " + resultTotal);

        num10 = Integer.parseInt(et10.getText().toString());
        result10 = 10*num10;
        resultTotal = result100 + result50 + result20 + result10;
        tv10.setText(" " + result10);
        tvTotal.setText(" " + resultTotal);

        num5 = Integer.parseInt(et5.getText().toString());
        result5 = 5*num5;
        resultTotal = result100 + result50 + result20 + result10 + result5;
        tv5.setText(" " + result5);
        tvTotal.setText(" " + resultTotal);

        num2 = Integer.parseInt(et2.getText().toString());
        result2 = 2*num2;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2;
        tv2.setText(" " + result2);
        tvTotal.setText(" " + resultTotal);

        num1 = Integer.parseInt(et1.getText().toString());
        result1 = 1*num1;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1;
        tv1.setText(" " + result1);
        tvTotal.setText(" " + resultTotal);

        num050 = Integer.parseInt(et050.getText().toString());
        result050 = 0.5*num050;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1 + result050;
        tv050.setText(" " + Math.round(result050*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num025 = Integer.parseInt(et025.getText().toString());
        result025 = 0.25*num025;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1 + result050 + result025;
        tv025.setText(" " + Math.round(result025*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);


        num010 = Integer.parseInt(et010.getText().toString());
        result010 = 0.1*num010;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1 + result050 + result010;
        tv010.setText(" " + Math.round(result010*10.0)/10.0);
        tvTotal.setText(" " + Math.round(resultTotal*10.0)/10.0);

        num005 = Integer.parseInt(et005.getText().toString());
        result005 = 0.05*num005;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1 + result050 + result025 + result010 + result005;
        tv005.setText(" " + Math.round(result005*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);

        num001 = Integer.parseInt(et001.getText().toString());
        result001 = 0.01*num001;
        resultTotal = result100 + result50 + result20 + result10 + result5 + result2 + result1 + result050 + result025 + result010 + result005 + result001;
        tv001.setText(" " + Math.round(result001*100.0)/100.0);
        tvTotal.setText(" " + Math.round(resultTotal*100.0)/100.0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        switch (item.getItemId()) {
            case MENU_RESET_ID:
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
                et2.setText("0");
                tv2.setText("");
                et1.setText("0");
                tv1.setText("");
                et050.setText("0");
                tv050.setText("");
                et025.setText("0");
                tv025.setText("");
                et010.setText("0");
                tv010.setText("");
                et005.setText("0");
                tv005.setText("");
                et001.setText("0");
                tv001.setText("");
                tvTotal.setText("Total");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
