package com.example.dinnerly;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  AfterScan extends AppCompatActivity implements RestaurantMenuFragment.OnMessageSendListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);
        button = (Button)findViewById(R.id.ordernow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfterScan.this,OrderPlaced.class);
                startActivity(intent);
            }
        });
    }

    public void onMessageSend(int[] ind, String[] selectedItems) {

        SelectedMenuFragment selectedMenuFragment = new SelectedMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("selectedItems", selectedItems);
        bundle.putIntArray("ind",ind);
        selectedMenuFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedMenuFragment,null);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
