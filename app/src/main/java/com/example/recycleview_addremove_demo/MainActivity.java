package com.example.recycleview_addremove_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText edtName, edtCost;
    private Spinner spinner;
    private Button addBtn;
    RecyclerView catRec;
    List<Cat> listCat = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initSpinner();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCat();
                initRecycleView();
            }
        });
    }

    private void init(){
        edtCost = findViewById(R.id.edtCost);
        edtName = findViewById(R.id.edtName);
        addBtn = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner2);
        catRec = findViewById(R.id.catRec);
    }
    private void initSpinner(){
        // Spinner Drop down elements
        List<String> catSpin = new ArrayList<String>();
        catSpin.add("1");
        catSpin.add("2");
        catSpin.add("3");
        catSpin.add("4");
        ArrayAdapter<String> catSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, catSpin);
        catSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(catSpinnerAdapter);
    }
    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        catRec.setLayoutManager(layoutManager);
        CatAdapter adapter = new CatAdapter(listCat, this);
        catRec.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void addCat(){
        Cat cat = new Cat(1,"","");
        cat.setName(edtName.getText().toString());
        cat.setCost(edtCost.getText().toString());
        spinner.setOnItemSelectedListener(this);
        /*switch (spinner.getSelectedItem().toString()){
            case "1": cat.setImg(R.drawable.a);
            case "2": cat.setImg(R.drawable.b);
            case "3": cat.setImg(R.drawable.c);
            case "4": cat.setImg(R.drawable.d);
        }*/
        int i = spinner.getSelectedItemPosition();
        if(i==0) cat.setImg(R.drawable.a); else
            if (i==1) cat.setImg(R.drawable.b); else
                if (i==2) cat.setImg(R.drawable.c); else
                    cat.setImg(R.drawable.d);
        listCat.add(cat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}