package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class AddStudentActivity extends AppCompatActivity {

    private Button addTodoBtn;
    private EditText kelasEditText;
    private EditText namaEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        kelasEditText = (EditText) findViewById(R.id.kelas_edittext);
        namaEditText = (EditText) findViewById(R.id.nama_edittext);
        addTodoBtn = (Button) findViewById(R.id.add_record);
// Membuat objek dari kelas DBManager
        dbManager = new DBManager(this);
        dbManager.open();
    }
    public void save(View v) {
// Mengambil data inputan user
        final String kelas = kelasEditText.getText().toString();
        final String nama = namaEditText.getText().toString();
/* Memanggil fungsi insert melalui objek dbManager dengan parameter
nilaikelas dan nama */
        dbManager.insert(kelas, nama);
// Memindahkan halaman kembali ke daftar siswa
        Intent main = new Intent(AddStudentActivity.this,
                DataStudentActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(main);
    }
    }
