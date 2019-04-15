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

public class Hasil extends AppCompatActivity {

    @BindView(R.id.txtNpm)
    TextView txtNpm;
    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtNilai)
    TextView txtNilai;
    @BindView(R.id.txtGrade)
    TextView txtGrade;

    String strNpm, strNama, strNilai, strGrade;
    double dblNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        ButterKnife.bind(this);

        Intent getData = getIntent();
        strNpm = getData.getStringExtra("npm");
        strNama = getData.getStringExtra("nama");
        strNilai = getData.getStringExtra("nilai");
        strGrade = getData.getStringExtra("grade");

        dblNilai = Double.parseDouble(strNilai);

        txtNpm.setText(strNpm);
        txtNama.setText(strNama);
        txtNilai.setText(strNilai);
        txtGrade.setText(strGrade);

        if (dblNilai >= 80 && dblNilai <= 100) {
            txtGrade.setText("A");
        } else if (dblNilai >= 65 && dblNilai <= 79) {
            txtGrade.setText("B");
        } else if (dblNilai >= 60 && dblNilai <= 64) {
            txtGrade.setText("C");
        } else if (dblNilai >= 40 && dblNilai <= 59) {
            txtGrade.setText("D");
        } else {
            txtGrade.setText("E");
        }
    }
}
