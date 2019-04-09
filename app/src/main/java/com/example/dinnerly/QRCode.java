package com.example.dinnerly;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCode extends AppCompatActivity {
    private Button button_scan;
    private Button button_next;
    private static final int MIN_FRAME_WIDTH = 240;  // (your desired value here)
    private static final int MIN_FRAME_HEIGHT = 240;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_scan = findViewById(R.id.button_scan);
        button_next = findViewById(R.id.button);
        button_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator= new IntentIntegrator(QRCode.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
                //integrator.setScanningRectangle(450, 450);
                //basically initiateScan internally passes an intent to OS and fir iska
                // code tu hoga and that(android will call) will call onActivityResult

            }
        });
    }

    @Override
    //humara app intent ke through OS(android) se interact krta hai we have 2 types of intent Explicit and implicit
    //Explicit when we tell OS ko khud se ki konsi activity kholni hai
    //implicit mai we just tell OS what we want like what functon we want and OS will open khudse ek nai activity kholta hai like in this it will open camera activity khudse and camera is a new activity
    //onActivityResult android ka function hai zxing ka nai, isse ta call krte hau
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode is the unique identifier to intentifiy two different requests
        //resultCode tell ki operation successfull tha ya nai
        //Intent data is the message that OS passes to us
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null)
        {
            if(result.getContents()==null)
            {
                showToast("you cancelled");
            }
            else
            {
                showToast(result.getContents());
                //print(result.getContents());
                //Intent intent= new Intent(MainActivity.this,Main2Activity.class );
                //intent.putExtra("message",result.getContents());
                //startActivity(intent);
            }
        }
        else{
            showToast("unable to find data");
        }
    }
    public void showToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}

