package com.example.recycleview_addremove_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Button cal;
    private EditText edt1, edt2;
    private TextView result;
    private Spinner spinner;
    Float a,b,rel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cal, container,false);
        return  v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        spinner.setOnItemSelectedListener(this);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Float.parseFloat(edt1.getText().toString());
                b= Float.parseFloat(edt2.getText().toString());
                int i = spinner.getSelectedItemPosition();
                if (i==0) rel = a+b;
                if (i==1) rel = a-b;
                if (i==2) rel = a*b;
                if (i==3){
                    if(b==0){
                        Toast.makeText(getContext(), "Nhap lai b khac 0 " , Toast.LENGTH_LONG).show();
                        result.setText("N/A");
                    } else {
                        rel = a/b;
                        result.setText(rel.toString());
                    }
                } else
                    result.setText(rel.toString());
            }
        });
    }
    private void init(View v){
        cal = v.findViewById(R.id.Addbutton);
        edt1 = v.findViewById(R.id.edt1);
        edt2= v.findViewById(R.id.edt2);
        spinner = v.findViewById(R.id.spinner);
        result = v.findViewById(R.id.result);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
