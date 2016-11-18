package com.supercilex.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener {
    private static FirebaseDatabase sDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef = getDatabase();
        mRef.push().setValue(1);
        mRef.push().setValue(1);
        mRef.push().setValue(1);
        mRef.push().setValue(1);
        mRef.push().setValue(1);
        mRef.push().setValue(2);
        mRef.push().setValue(2);
        mRef.push().setValue(2);
        mRef.push().setValue(2);
        mRef.addValueEventListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        if (snapshot != null) {
            ((TextView) findViewById(R.id.text)).setText("success:\n" + snapshot);
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        ((TextView) findViewById(R.id.text)).setText(error.getMessage());
    }

    private static DatabaseReference getDatabase() {
        if (sDatabase == null) {
            sDatabase = FirebaseDatabase.getInstance();
        }
        return sDatabase.getReference();
    }
}
