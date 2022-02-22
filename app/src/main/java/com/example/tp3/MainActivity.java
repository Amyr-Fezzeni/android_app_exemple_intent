package com.example.tp3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
                openSomeActivityForResult();
            }
        });

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        String reply = result.getData().getStringExtra("reply");
                        if (reply.isEmpty()){
                            Toast.makeText(MainActivity.this, "Chaine vide!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            msg.setText(msg.getText().toString() +"\n\n" + reply);
                        }

                    }
                }
            });

    public void openSomeActivityForResult() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        String _msg = msgEdit.getText().toString();
        intent.putExtra("msg", _msg);
        someActivityResultLauncher.launch(intent);
    }

}