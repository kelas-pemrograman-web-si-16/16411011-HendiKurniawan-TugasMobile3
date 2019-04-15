package com.example.nilai;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edNama)
    EditText edNama;
    @BindView(R.id.edNpm)
    EditText edNpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnSubmit)
    void btnSubmit(){
        String strNpm, strNama;

        strNpm = edNpm.getText().toString();
        strNama = edNama.getText().toString();

        if(strNpm.isEmpty() || strNama.isEmpty()){
            Toast.makeText(getApplicationContext(),"Lengkapi data", Toast.LENGTH_LONG).show();
        }else {
            Intent a = new Intent(MainActivity.this, InputNilai.class);
            a.putExtra("npm", strNpm);
            a.putExtra("nama", strNama);
            startActivity(a);
            finish();
        }
    }
}
