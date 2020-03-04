package com.example.a4thclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.kofigyan.stateprogressbar.components.StateItem;
import com.kofigyan.stateprogressbar.listeners.OnStateItemClickListener;

public class MainActivity extends AppCompatActivity {

    private StateProgressBar stateProgressBar;
    String[] stateTitle = {"SignUp", "Confirm"};

    private FrameLayout frameLayout;

    private SignUpFragment signUpFragment;
    private ConfirmFragment confirmFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        frameLayout = findViewById(R.id.frameLayId);
        stateProgressBar = findViewById(R.id.stateProgressbarId);


        signUpFragment = new SignUpFragment();
        confirmFragment = new ConfirmFragment();

        setFragment(signUpFragment);


        stateProgressBar.setStateDescriptionData(stateTitle);
        stateProgressBar.setCurrentStateDescriptionColor(Color.parseColor("#808080"));




    }


    public void nextState() {

        switch (stateProgressBar.getCurrentStateNumber()) {

            case 1:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                setFragment(confirmFragment);
                break;

        }
    }


    public void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayId, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);


        return true;


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.shareId:
                Toast.makeText(this, "Sahre is Clicked", Toast.LENGTH_SHORT).show();
            return true;

            default:
                return false;
        }


    }
}
