package com.example.recycleview_addremove_demo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView reSearch;
    EditText inputName;
    Button btnSearch;
    List<Cat> cats = new ArrayList<>();
    List<Cat> catsOutput = new ArrayList<>();
    String img, name, cost;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container,false);
        addCat();
        return  v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<cats.size();i++){
                    if(cats.get(i).getName().equals(inputName.getText().toString())){
                        catsOutput.add(cats.get(i));
                    } else Toast.makeText(getContext(), "Khong co item nao", Toast.LENGTH_LONG).show();
                }
                initRecycleView();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        addCat();
    }

    private void init(View v){
        reSearch = v.findViewById(R.id.recSearch);
        inputName = v.findViewById(R.id.edtID);
        btnSearch = v.findViewById(R.id.btnSearch);
    }
    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        reSearch.setLayoutManager(layoutManager);
        CatAdapter adapter = new CatAdapter(catsOutput, getContext());
        reSearch.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void addCat(){
       cats = ((MainActivity)getActivity()).list;
    }
}
