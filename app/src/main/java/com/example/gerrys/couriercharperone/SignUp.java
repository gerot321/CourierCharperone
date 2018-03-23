package com.example.gerrys.couriercharperone;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gerrys.couriercharperone.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText etPhone, etName, etPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        String[] Base = { "GedungB", "GedungF", "FJ", "DP"};
        etPhone = (MaterialEditText)findViewById(R.id.etPhone);
        etName = (MaterialEditText)findViewById(R.id.etName);
        etPassword = (MaterialEditText)findViewById(R.id.etPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        ArrayAdapter< String > adapter = new ArrayAdapter<String>(SignUp.this, android.R.layout.simple_spinner_item, Base);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner popupSpinner = (Spinner)findViewById(R.id.spinner2);
        popupSpinner.setAdapter(adapter);
        // I
        // nitialize firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("loading...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Check if already user phone
                        if(dataSnapshot.child(etPhone.getText().toString()).exists()){
                            mDialog.dismiss();

                            Toast.makeText(SignUp.this, "Account already exist!", Toast.LENGTH_SHORT).show();
                        }else {
                            mDialog.dismiss();

                            User user = new User(etName.getText().toString(), etPassword.getText().toString(), "Merchant",popupSpinner.getSelectedItem().toString());
                            table_user.child(etPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Account successfully created!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
