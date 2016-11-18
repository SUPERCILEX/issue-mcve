package com.supercilex.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ValueEventListener {
    private static FirebaseDatabase sDatabase;
    private DatabaseReference mRef = getDatabase().push();
    private List<String> mKeys = new ArrayList<>();

    private static DatabaseReference getDatabase() {
        if (sDatabase == null) {
            sDatabase = FirebaseDatabase.getInstance();
        }
        return sDatabase.getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference ref;
        ref = mRef.push();
        mKeys.add(ref.getKey());
        ref.setValue(Long.parseLong("1")); // The point here is that the database thinks
        // that anything other than an int is a string and orders the keys lexicographically :(

        ref = mRef.push();
        mKeys.add(ref.getKey());
        ref.setValue(Long.parseLong("1"));

        ref = mRef.push();
        mKeys.add(ref.getKey());
        ref.setValue(Long.parseLong("1"));

        mRef.push().setValue(Long.parseLong("2")); // Just to show that my data has other numbers like so

        mRef.orderByValue().equalTo(1).addValueEventListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRef.removeEventListener(this);
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        if (snapshot != null) {
            ((TextView) findViewById(R.id.text)).setText(
                    "success:\n\n"
                            + "correct order:\n"
                            + mKeys
                            + "\n\nactual order:\n"
                            + snapshot.getValue());
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        ((TextView) findViewById(R.id.text)).setText(error.getMessage());
    }
}
