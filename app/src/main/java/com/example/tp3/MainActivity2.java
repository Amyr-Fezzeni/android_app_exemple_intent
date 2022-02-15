package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btn2 = findViewById(R.id.button2);
        TextView msg2 = findViewById(R.id.msg2);
        EditText editText = findViewById(R.id.msgedit2);

        String msgRecived = super.getIntent().getStringExtra("msg");
        if (!msgRecived.isEmpty()){
            msg2.setText(msg2.getText().toString() +"\n\n" + msgRecived);
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = editText.getText().toString();
                MainActivity2.super.getIntent().putExtra("reply", reply);
                MainActivity2.this.setResult(RESULT_OK, MainActivity2.super.getIntent());
                MainActivity2.this.finish();
            }
        });

    }
}