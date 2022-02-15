package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView msg;
    EditText msgEdit;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.msg2);
        btn = findViewById(R.id.button);
        msgEdit = findViewById(R.id.msgedit1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _msg = msgEdit.getText().toString();
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("msg", _msg);
                MainActivity.this.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra("reply");
                if (reply.isEmpty()){
                    Toast.makeText(this, "Chaine vide!", Toast.LENGTH_LONG).show();
                }
                else{
                    msg.setText(msg.getText().toString() +"\n\n" + reply);
                }
                }
        }
    }
}