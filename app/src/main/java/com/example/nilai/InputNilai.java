package com.example.nilai;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InputNilai extends AppCompatActivity {

    @BindView(R.id.edNpm)
    EditText edNpm;
    @BindView(R.id.edNama)
    EditText edNama;
    @BindView(R.id.edTugas)
    EditText edTugas;
    @BindView(R.id.edQuiz)
    EditText edQuiz;
    @BindView(R.id.edUTS)
    EditText edUTS;
    @BindView(R.id.edUAS)
    EditText edUAS;


    String strNpm, strNama, strGrade;
    double dblTugas, dblQuiz, dblUTS, dblUAS, dblNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai);

        ButterKnife.bind(this);

        Intent getData = getIntent();
        strNpm = getData.getStringExtra("npm");
        strNama = getData.getStringExtra("nama");

        edNpm.setText(strNpm);
        edNama.setText(strNama);

    }
    @OnClick(R.id.btnHitung)
    void btnHitung(){


        dblTugas = Double.parseDouble(edTugas.getText().toString());
        dblQuiz  = Double.parseDouble(edQuiz.getText().toString());
        dblUTS   = Double.parseDouble(edUTS.getText().toString());
        dblUAS   = Double.parseDouble(edUAS.getText().toString());

        dblNilai = (dblTugas + dblQuiz + dblUTS + dblUAS) / 4;


        /*Toast.makeText(getApplicationContext(), String.valueOf(dblHasil),Toast.LENGTH_LONG).show();*/
        Intent a = new Intent(InputNilai.this, Hasil.class);
        a.putExtra("npm", strNpm);
        a.putExtra("nama", strNama);
        a.putExtra("nilai", String.valueOf(dblNilai));
        a.putExtra("grade", strGrade);


        startActivity(a);
        finish();



    }

}
