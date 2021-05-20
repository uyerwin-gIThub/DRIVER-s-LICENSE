package com.example.driverslicenseapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button $btnSubmit, $btnphoto;
    EditText $lName, $fName, $mName, $race, $maleFemale;
    EditText $houseNo, $streetBrgy, $cityMun, $province;
    EditText $dOfBirth, $cm, $kg;
    Spinner $spinnerBtype, $spinnerEyeC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        $btnSubmit = findViewById(R.id.btnSubmit);

        $spinnerBtype = findViewById(R.id.spinnerBtype);
        $spinnerEyeC = findViewById(R.id.spinnerEyeC);

        $lName = findViewById(R.id.lName);
        $fName = findViewById(R.id.fName);
        $mName = findViewById(R.id.mName);
        $houseNo = findViewById(R.id.houseNo);
        $streetBrgy = findViewById(R.id.streetBrgy);
        $cityMun = findViewById(R.id.cityMun);
        $province = findViewById(R.id.province);
        $dOfBirth = findViewById(R.id.dOfBirth);
        $race = findViewById(R.id.race);
        $cm = findViewById(R.id.cm);
        $kg = findViewById(R.id.kg);
        $maleFemale = findViewById(R.id.maleFemale);

        List<String> bloodtype = Arrays.asList("A", "B", "O", "AB", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");
        ArrayAdapter blood =  new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, bloodtype);
        blood.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        $spinnerBtype.setAdapter(blood);

        List<String> eyecolor = Arrays.asList("BROWN", "BLACK", "BLUE", "GREEN", "GREY");
        ArrayAdapter Ecolor = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,eyecolor);
        Ecolor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        $spinnerEyeC.setAdapter(Ecolor);



        $btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialAlertDialogBuilder build = new MaterialAlertDialogBuilder(MainActivity.this);
                build.setTitle("CONFIRMATION");
                build.setMessage("Are you Sure?");
                build.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            String _lName = $lName.getText().toString();
                            String _fName = $fName.getText().toString();
                            String _mName = $mName.getText().toString();
                            String _streetBrgy = $streetBrgy.getText().toString();
                            String _cityMun = $cityMun.getText().toString();
                            String _province = $province.getText().toString();
                            String _race = $race.getText().toString();
                            String _dOfBirth = $dOfBirth.getText().toString();
                            String _maleFemale = $maleFemale.getText().toString();

                            String _cm = $cm.getText().toString();
                            String _kg = $kg.getText().toString();
                            String _houseNo = $houseNo.getText().toString();

                            String btype = $spinnerBtype.getSelectedItem().toString();
                            String etype = $spinnerEyeC.getSelectedItem().toString();


                            Intent i = new Intent(MainActivity.this, licensePreview.class);
                            i.putExtra("DATA_lName", _lName);
                            i.putExtra("DATA_fName", _fName);
                            i.putExtra("DATA_mName", _mName);
                            i.putExtra("DATA_houseNo", _houseNo);
                            i.putExtra("DATA_streetBrgy", _streetBrgy);
                            i.putExtra("DATA_cityMun", _cityMun);
                            i.putExtra("DATA_province", _province);
                            i.putExtra("DATA_race", _race);
                            i.putExtra("DATA_dOfBirth", _dOfBirth);
                            i.putExtra("DATA_cm", _cm);
                            i.putExtra("DATA_kg", _kg);
                            i.putExtra("DATA_maleFemale", _maleFemale);
                            i.putExtra("DATA_dOfBirth", _dOfBirth);
                            i.putExtra("DATA_Btype", btype);
                            i.putExtra("DATA_color", etype);
                            startActivity(i);
                        Toast.makeText(getApplicationContext(), "SUBMITTED", Toast.LENGTH_SHORT).show();
                    }
                });
                build.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "APPLICATION NOT SUBMITTED", Toast.LENGTH_SHORT).show();
                    }
                });
                build.show();
            }
        });
    }
}