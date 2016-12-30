package com.supercilex.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ValueEventListener {
    private static FirebaseDatabase sDatabase;
    private DatabaseReference mRef = getDatabase().child("x");

    private static DatabaseReference getDatabase() {
        if (sDatabase == null) {
            sDatabase = FirebaseDatabase.getInstance();
            sDatabase.setPersistenceEnabled(true);
        }
        return sDatabase.getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, Long> values = new HashMap<>();
        values.put(mRef.push().getKey(), 2521L);
        values.put(mRef.push().getKey(), 2521L);
        values.put(mRef.push().getKey(), 2521L);

        mRef.push().setValue(values);
        mRef.push().setValue(values);
        mRef.push().setValue(values);

        Query ref = mRef.push();
        ref.getRef().setValue(values);

        mRef.child(ref.getRef().getKey()).addValueEventListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        if (snapshot != null) {
            ((TextView) findViewById(R.id.text)).setText("success:\n\n" + snapshot.getValue());
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        ((TextView) findViewById(R.id.text)).setText(error.getMessage());
    }
}
