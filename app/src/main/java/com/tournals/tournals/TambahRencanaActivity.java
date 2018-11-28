package com.tournals.tournals;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TambahRencanaActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText edtTanggalPergiPicker;
    private EditText edtTanggalPulangPicker;
    private EditText edtWaktu;
    private TimePickerDialog timePickerDialog;
    private EditText edtPilihTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_rencana);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tambahRencanaToolbar);
        ImageView ivBack = (ImageView) findViewById(R.id.tambahRencanaBack);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        edtTanggalPergiPicker = (EditText) findViewById(R.id.edtTanggalPergi);
        edtTanggalPulangPicker = (EditText) findViewById(R.id.edtTanggalPulang);
        edtPilihTanggal = (EditText) findViewById(R.id.edtPilihTanggal);
        edtWaktu = (EditText) findViewById(R.id.edtWaktu);
        EditText edtLokasi = (EditText) findViewById(R.id.edtLokasi);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        edtTanggalPergiPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edtTanggalPergiPicker);
            }
        });
        edtTanggalPulangPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edtTanggalPulangPicker);
            }
        });

        edtWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
        edtLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() ,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void showDateDialog(final EditText TanggalResult){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                TanggalResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
    private void showTimeDialog() {

        /**
         * Calendar untuk mendapatkan waktu saat ini
         */
        Calendar calendar = Calendar.getInstance();

        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                /**
                 * Method ini dipanggil saat kita selesai memilih waktu di DatePicker
                 */
                edtWaktu.setText(hourOfDay+":"+minute);
            }
        },
                /**
                 * Tampilkan jam saat ini ketika TimePicker pertama kali dibuka
                 */
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),

                /**
                 * Cek apakah format waktu menggunakan 24-hour format
                 */
                DateFormat.is24HourFormat(this));

        timePickerDialog.show();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}