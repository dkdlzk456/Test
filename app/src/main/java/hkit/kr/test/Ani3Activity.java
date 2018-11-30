package hkit.kr.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ani3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani3);

        Intent intent = getIntent();
        String charName2 = intent.getStringExtra("charName2");
        setTitle(charName2);

        Button button = findViewById(R.id.idButton);
        button.setOnClickListener(onClickListener);

        Button button2 = findViewById(R.id.idButton2);
        button2.setOnClickListener(onClickListener2);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}
