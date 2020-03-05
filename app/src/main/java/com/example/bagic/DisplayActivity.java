package com.example.bagic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);

        TextView nameParcelable = findViewById(R.id.tv_name_parcelable);
        TextView rateParcelable = findViewById(R.id.tv_rate_parcelable);

        TextView nameSerializable = findViewById(R.id.tv_name_serializable);
        TextView rateSerializable = findViewById(R.id.tv_rate_serializable);

        Intent intent = getIntent();

        MovieParcelable parcelable = intent.getParcelableExtra("ParcelableObject");

        nameParcelable.setText("제목 : " + parcelable.getName());
        rateParcelable.setText("평점 : " + parcelable.getRate());

        MovieSerializable serializable = (MovieSerializable) intent.getSerializableExtra("SerializableObject");

        nameSerializable.setText("제목 : " + serializable.getName());
        rateSerializable.setText("평점 : " + serializable.getRate());

    }
}
