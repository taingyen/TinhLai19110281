package com.android.s1910281;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private double Interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = getIntent();
        double deposit = Double.parseDouble(intent.getStringExtra("TIEN_GUI"));
        double interest = Double.parseDouble(intent.getStringExtra("LAI_SUAT")) ;
        double time_deposit = Double.parseDouble(intent.getStringExtra("KY_HAN"));
        this.Interest =  (deposit*interest/100*(time_deposit*30))/360;
        Interest = Math.round(Interest*100.0)/100.0;
        TextView tienLaiView = findViewById(R.id.tienlai);
        tienLaiView.setText(String.valueOf(Interest) + " đ");
        TextView tongtienView = findViewById(R.id.tongtien);
        tongtienView.setText(String.valueOf(Interest + deposit)+ " đ");
    }
    public void takeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            finish();
        }
    }
}