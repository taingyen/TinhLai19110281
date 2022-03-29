package com.android.s1910281;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText depositinput;
    private EditText interestinput;
    private EditText timedepositinput;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        depositinput = findViewById(R.id.tiengui);
        interestinput = findViewById(R.id.laisuat);
        timedepositinput = findViewById(R.id.kyhan);
    }
    public void getResult(View view){
        if (depositinput.getText().toString().length() == 0 ||interestinput.getText().toString().length() == 0 ||
                timedepositinput.getText().toString().length() == 0){
            Toast.makeText(this, "All textbox is required", Toast.LENGTH_SHORT).show();
        }
        else {
            String deposit = depositinput.getText().toString();
            String interest = interestinput.getText().toString();
            String time_deposit = timedepositinput.getText().toString();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("TIEN_GUI", deposit);
            intent.putExtra("LAI_SUAT", interest);
            intent.putExtra("KY_HAN", time_deposit);
            startActivityForResult(intent,TEXT_REQUEST);
        }

    }
}