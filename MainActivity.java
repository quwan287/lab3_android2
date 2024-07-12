package fpl.quangnm.lab1.demo3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import fpl.quangnm.lab1.R;

public class MainActivity extends AppCompatActivity {
    private Button btn1_demo3,btn2_demo3,btn3_demo3;
    Context context = this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn1_demo3 = findViewById(R.id.btn1_demo3);
        btn2_demo3 = findViewById(R.id.btn2_demo3);
        btn3_demo3 = findViewById(R.id.btn3_demo3);


        btn1_demo3.setOnClickListener(view -> {
            String[] arr = {"Xanh","Do","Tim","Vang"};

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Tieu De");

            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Ban Chon " +arr[i], Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });


       btn2_demo3.setOnClickListener(view -> {
           String[] arr = {"Xanh","Do","Tim","Vang"};

           AlertDialog.Builder builder = new AlertDialog.Builder(context);

           builder.setTitle("Tieu De");

           builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                   Toast.makeText(MainActivity.this, "Ban Chon " +arr[i], Toast.LENGTH_SHORT).show();
               }
           });

           AlertDialog alertDialog = builder.create();
           alertDialog.show();
       });

       btn3_demo3.setOnClickListener(view -> {
           AlertDialog.Builder builder = new AlertDialog.Builder(context);

           LayoutInflater inflater = getLayoutInflater();
           View view1 = inflater.inflate(R.layout.demo31_login_form, null);
           builder.setView(view1);

           final EditText txtUser = view1.findViewById(R.id.demo31_edtlogin_form);
           final EditText txtPass = view1.findViewById(R.id.demo31_pass_edt);
           final EditText demo31_pass1_edt = view1.findViewById(R.id.demo31_pass1_edt);
           builder.setTitle("Login form");
           builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), "Xin Chao"+txtUser.getText().toString() , Toast.LENGTH_SHORT).show();
               }
           });
           builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(getApplicationContext(), "Logout"+txtUser.getText().toString() , Toast.LENGTH_SHORT).show();
               }
           });
           AlertDialog alertDialog = builder.create();
           alertDialog.show();
       });
    }
}