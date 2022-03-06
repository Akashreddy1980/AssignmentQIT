package com.aimsmart.app.assignmentqit;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupFragment extends Fragment {

    private FirebaseAuth mAuth;
    EditText email,password;
    EditText username,contact;
    Button reg;
    FirebaseUser firebaseUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        email = view.findViewById(R.id.mail);
        password = view.findViewById(R.id.password);
        username = view.findViewById(R.id.name);
        contact = view.findViewById(R.id.contactno);
        reg = view.findViewById(R.id.buttonreg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Email or Password cannot be null", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(username.getText().toString().equals("")&&username.getText().toString().length()<=3){
                        Toast.makeText(getActivity(), "username should be more than 3 characters", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(contact.getText().toString().length()!=10){
                            Toast.makeText(getActivity(), "InValid Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            auth(email.getText().toString().trim(),password.getText().toString().trim());
                        }
                    }
                }
            }
        });
        return view;
    }
    public void auth(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            startActivity(new Intent(getActivity(),MainActivity2.class));
                            getActivity().finish();
                        } else {
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public interface OnFragmemtInteractionListener {
    }
}