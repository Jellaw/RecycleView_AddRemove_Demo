package com.example.recycleview_addremove_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InputFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private EditText edtName, edtCost;
    private Spinner spinner;
    private Button addBtn;
    RecyclerView catRec;
    List<Cat> listCat = new ArrayList<>();
    SearchCat searchCat;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchCat ){
            searchCat= (SearchCat) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_input, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initSpinner();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCat();
                initRecycleView();
            }
        });
    }
    private void init(View v){
        edtCost = v.findViewById(R.id.edtCost);
        edtName = v.findViewById(R.id.edtName);
        addBtn = v.findViewById(R.id.button);
        spinner = v.findViewById(R.id.spinner2);
        catRec = v.findViewById(R.id.catRec);
    }
    private void initSpinner(){
        // Spinner Drop down elements
        List<String> catSpin = new ArrayList<String>();
        catSpin.add("1");
        catSpin.add("2");
        catSpin.add("3");
        ArrayAdapter<String> catSpinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, catSpin);
        catSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(catSpinnerAdapter);
    }
    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        catRec.setLayoutManager(layoutManager);
        CatAdapter adapter = new CatAdapter(listCat, getContext());
        catRec.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void addCat(){
        Cat cat = new Cat(1,"","");
        cat.setName(edtName.getText().toString());
        cat.setCost(edtCost.getText().toString());
        spinner.setOnItemSelectedListener(this);
        int i = spinner.getSelectedItemPosition();
        if(i==0) cat.setImg(R.drawable.a); else
        if (i==1) cat.setImg(R.drawable.b); else
            cat.setImg(R.drawable.c);
        listCat.add(cat);
        searchCat.getInfor(i +"-"+edtName.getText().toString()+"-"+edtCost.getText().toString());
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
