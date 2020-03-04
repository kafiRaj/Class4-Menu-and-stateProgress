package com.example.a4thclass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    View mainview;
    private EditText nameText, numberText, passText;
    Button nextBtn;


    String name, number, password;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainview = inflater.inflate(R.layout.fragment_sign_up, container, false);



        nameText = mainview.findViewById(R.id.nameId);
        numberText = mainview.findViewById(R.id.phoneId);
        passText = mainview.findViewById(R.id.passwordId);
        nextBtn = mainview.findViewById(R.id.nextBtnId);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!nameText.getText().toString().isEmpty() && !numberText.getText().toString().isEmpty()
                        && !passText.getText().toString().isEmpty()) {

                    ((MainActivity)getActivity()).nextState();

                } else {

                    Toast.makeText(getActivity().getApplicationContext(), "Please fill up all the field", Toast.LENGTH_SHORT).show();
                }


            }
        });




        return mainview;
    }



}
