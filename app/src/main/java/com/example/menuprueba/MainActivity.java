package com.example.menuprueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout r=findViewById(R.id.draweer);
        ImageView menu=findViewById(R.id.menuImg);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                r.openDrawer(GravityCompat.START);
            }
        });




        NavigationView nv=findViewById(R.id.nav);
        nv.setItemIconTintList(null);
        NavController contrlador= Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(nv,contrlador);


    }

}