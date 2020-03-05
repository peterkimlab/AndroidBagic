package com.example.bagic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.bt_send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                MovieParcelable parcelable = new MovieParcelable("하우스오브카드", 9.5);
                intent.putExtra("ParcelableObject", parcelable);

                MovieSerializable serializable = new MovieSerializable("워킹데드", 9);
                intent.putExtra("SerializableObject", serializable);

                startActivity(intent);
            }
        });
    }
}

// https://thepassion.tistory.com/276
// https://www.charlezz.com/?p=823