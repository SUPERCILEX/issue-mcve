package com.supercilex.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener, ChildEventListener {
    private static FirebaseDatabase sDatabase;
    private DatabaseReference mRef = getDatabase().push();

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

        // 1. Open the app while online and notice that two log statements are printed
        // 2. Go offline and rotate the activity, only the CHILD_EVENT is logged

        mRef.push().setValue(1);
        mRef.push().setValue(2);

        // Using a query doesn't cache the whole ref for some reason
        mRef.orderByValue().equalTo(1).addValueEventListener(this);
        mRef.orderByValue().equalTo(1).addChildEventListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener((ValueEventListener) this);
        mRef.removeEventListener((ChildEventListener) this);
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        Log.d("VALUE_EVENT", snapshot.toString());
    }

    @Override
    public void onChildAdded(DataSnapshot snapshot, String s) {
        Log.d("CHILD_EVENT", snapshot.toString());
    }

    @Override
    public void onChildChanged(DataSnapshot snapshot, String s) {
    }

    @Override
    public void onChildRemoved(DataSnapshot snapshot) {
    }

    @Override
    public void onChildMoved(DataSnapshot snapshot, String s) {
    }

    @Override
    public void onCancelled(DatabaseError error) {
        ((TextView) findViewById(R.id.text)).setText(error.getMessage());
    }
}
