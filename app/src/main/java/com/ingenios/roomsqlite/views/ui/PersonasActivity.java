package com.ingenios.roomsqlite.views.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ingenios.roomsqlite.R;
import com.ingenios.roomsqlite.repository.room.entities.Personas;
import com.ingenios.roomsqlite.views.adapters.PersonasAdapter;
import com.ingenios.roomsqlite.viewsmodels.PersonasViewModel;
import java.util.List;

public class PersonasActivity extends AppCompatActivity {
    private PersonasViewModel personasViewModel;
    private static final String TAG = PersonasActivity.class.getSimpleName();
    private RecyclerView rvUsuarios;
    private TextView txtNoData;
    private PersonasAdapter personasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        init();
        rvUsuarios.setLayoutManager(new LinearLayoutManager(this));
        personasAdapter = new PersonasAdapter(this);
        rvUsuarios.setAdapter(personasAdapter);

        personasViewModel = ViewModelProviders.of(this).get(PersonasViewModel.class);
        observeViewModel(personasViewModel);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        personasAdapter.setOnItemClickListener(new PersonasAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(PersonasActivity.this,"Usuario: " + personasAdapter.getPersona(position).getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUpdateClick(View view, int position) {
                Toast.makeText(PersonasActivity.this,"Actualizar: " + personasAdapter.getPersona(position).getId(), Toast.LENGTH_SHORT).show();
                //personasViewModel.findByPk(personasAdapter.getPersona(position).getId());
            }
        });
    }

    private void observeViewModel(PersonasViewModel viewModel) {
        // Update the list when the data changes
        viewModel.findAll().observe(this, new Observer<List<Personas>>() {
            @Override
            public void onChanged(@Nullable List<Personas> personas) {
                Log.e(TAG, "onChanged: " + personas.size());
                if (personas != null) {
                    personasAdapter.setPersonas(personas);
                    updateUI();
                }
            }
        });
    }

    private void init() {
        rvUsuarios = findViewById(R.id.mRecyclerView);
        txtNoData = findViewById(R.id.txtNodata);
    }

    private void updateUI() {

        int itemCount = personasAdapter.getItemCount();
        txtNoData.setVisibility(itemCount == 0 ? View.VISIBLE : View.GONE);
        rvUsuarios.setVisibility(itemCount == 0 ? View.GONE : View.VISIBLE);
        rvUsuarios.scrollToPosition(itemCount > 0 ? itemCount - 1 : 0);
    }


}
