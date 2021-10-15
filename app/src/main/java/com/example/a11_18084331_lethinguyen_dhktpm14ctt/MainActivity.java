package com.example.a11_18084331_lethinguyen_dhktpm14ctt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;
    Button btnADD, btnMUL, btnDIV, btnSUB;
    private EditText edtA, edtB, edtResult;
    private boolean isConnection;
    private MyService myService;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();
            isConnection = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnection = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        btnADD =findViewById(R.id.button);
        btnSUB =findViewById(R.id.button4);
        btnDIV =findViewById(R.id.button2);
        btnMUL =findViewById(R.id.button3);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtResult =findViewById(R.id.edtResult);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        img2.startAnimation(animation);
        img1.startAnimation(animation);
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(edtA.getText().toString());
                int B =  Integer.parseInt(edtB.getText().toString());
                int Result = myService.ADD(A,B);
                edtResult.setText(String.valueOf(Result));
            }
        });
        btnDIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(edtA.getText().toString());
                int B =  Integer.parseInt(edtB.getText().toString());
                double Result = myService.DIV(A,B);
                edtResult.setText(String.valueOf(Result));
            }
        });
        btnMUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(edtA.getText().toString());
                int B =  Integer.parseInt(edtB.getText().toString());
                int Result = myService.MUL(A,B);
                edtResult.setText(String.valueOf(Result));
            }
        });
        btnSUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(edtA.getText().toString());
                int B =  Integer.parseInt(edtB.getText().toString());
                int Result = myService.SUB(A,B);
                edtResult.setText(String.valueOf(Result));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }
}