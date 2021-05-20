package com.example.driverslicenseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class licensePreview extends AppCompatActivity {


    TextView $lastName, $firstName, $middleName, $dataNationality, $dataSex, $dataBday, $dataWeight, $dataHeight, $dataAddress, $dataBlood, $dataEcolor;
    Button $btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_preview);

        $lastName = findViewById(R.id.lastName);
        $firstName = findViewById(R.id.firstName);
        $middleName = findViewById(R.id.middleName);
        $dataNationality = findViewById(R.id.dataNationality);
        $dataSex = findViewById(R.id.dataSex);
        $dataWeight = findViewById(R.id.dataWeight);
        $dataHeight = findViewById(R.id.dataHeight);
        $dataBday = findViewById(R.id.dataBday);
        $dataAddress = findViewById(R.id.dataAddress);
        $btnGoBack = findViewById(R.id.btnGoBack);
        $dataBlood = findViewById(R.id.dataBlood);
        $dataEcolor = findViewById(R.id.dataEcolor);

        Intent i = getIntent();

        String _lastName = i.getStringExtra("DATA_lName");
        $lastName.setText(_lastName.toUpperCase());

        String _firstName = i.getStringExtra("DATA_fName");
        $firstName.setText(_firstName.toUpperCase());

        String _middleName = i.getStringExtra("DATA_mName");
        $middleName.setText(_middleName.toUpperCase());

        String _dataNationality = i.getStringExtra("DATA_race");
        $dataNationality.setText(_dataNationality.toUpperCase());

        String _dataSex = i.getStringExtra("DATA_maleFemale");
        $dataSex.setText(_dataSex.toUpperCase());

        String _dataWeight = i.getStringExtra("DATA_cm");
        $dataWeight.setText(_dataWeight);

        String _dataHeight = i.getStringExtra("DATA_kg");
        $dataHeight.setText(_dataHeight);

        String _dataBday = i.getStringExtra("DATA_dOfBirth");
        $dataBday.setText(_dataBday);

        String _dataBlood = i.getStringExtra("DATA_Btype");
        $dataBlood.setText(_dataBlood);

        String _dataEcolor = i.getStringExtra("DATA_color");
        $dataEcolor.setText(_dataEcolor);

        String _dataAddress = i.getStringExtra("DATA_houseNo");
        String _dataStreetBrgy = i.getStringExtra("DATA_streetBrgy");
        String _dataCityMun = i.getStringExtra("DATA_cityMun");
        String _dataProvince = i.getStringExtra("DATA_province");
        $dataAddress.setText(_dataAddress +" "+ _dataStreetBrgy.toUpperCase() +", "+ _dataCityMun.toUpperCase() +", "+ _dataProvince.toUpperCase());

        $btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(licensePreview.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}