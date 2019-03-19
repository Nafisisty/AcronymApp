package com.example.acronymapp.view.activities.mainactivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.acronymapp.R;
import com.example.acronymapp.databinding.ActivityMainBinding;
import com.example.acronymapp.model.datasource.acronym.Acronym;
import com.example.acronymapp.view.adapters.RecyclerViewAdapter;
import com.example.acronymapp.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        activityMainBinding.setMainViewModel(mainViewModel);
        activityMainBinding.executePendingBindings();
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainViewModel.getAcronymLiveData().observe(this, new Observer<List<Acronym>>() {
            @Override
            public void onChanged(@Nullable List<Acronym> acronyms) {

                if(acronyms != null && acronyms.size() > 0) {

                    Log.d("TAG", "observer Changed: " + acronyms.get(0).getSf());

                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<>(acronyms.get(0).getLfs()));
                    activityMainBinding.recyclerView.setAdapter(recyclerViewAdapter);

                }
                else {

                    Toast.makeText(getBaseContext(), "No data for this acronym.", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}
