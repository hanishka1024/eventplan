package com.example.eventplan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnSelectImage;
    private Button btnSelectDate,btnSubmit;
    private TextView tvSelectDate;
    private RadioGroup radioGroupEvent;
    private CheckBox checkCatering, checkPhotography,checkMusic;
    private Uri imageUri;
    private static final int PICK_IMAGE_REQUEST=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSelectImage=findViewById(R.id.btnSelectImage);
        btnSelectDate=findViewById(R.id.btnSelectDate);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvSelectDate=findViewById(R.id.tvSelectDate);
        radioGroupEvent=findViewById(R.id.radioGroupEvent);
        checkCatering=findViewById(R.id.cbCatering);
        checkPhotography=findViewById(R.id.cbPhotography);
        checkMusic=findViewById(R.id.cbLiveMusic);
        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChoose();
            }
        });
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processForm();
            }
        });
    }
    private void openImageChoose()
    {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null){
            imageUri=data.getData();
            try{
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                btnSelectImage.setImageBitmap(bitmap);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Button getBtnSelectDate() {
        return btnSelectDate;
    }
    private void showDatePicker(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this, (view,selectedYear,selectedMonth,selectedDay) -> {
            tvSelectDate.setText("Date:"+selectedYear+"/"+(selectedMonth+1)+"/"+selectedDay);
        },year,month,day).show();
    }
    private void processForm(){
        int selectedEventid=radioGroupEvent.getCheckedRadioButtonId();
        String eventType = selectedEventid != -1 ? ((RadioButton)findViewById(selectedEventid)).getText().toString():"Not Selected";
        String services="";
        if(checkCatering.isChecked()) services += " Catering";
        if(checkPhotography.isChecked())  services +=" Photography";
        if(checkMusic.isChecked()) services +=" Live Music";


        Toast.makeText(this,eventType+"\n"+services,Toast.LENGTH_LONG).show();
    }
}