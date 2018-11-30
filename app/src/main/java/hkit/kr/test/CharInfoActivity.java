package hkit.kr.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CharInfoActivity extends AppCompatActivity {
    TextView charInfoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_info);
        charInfoTextView = findViewById(R.id.charInfoTextView);
        Intent intent = getIntent();
        String charName = intent.getStringExtra("charName");
        String charInfo = findCharInfo(charName);
        charInfoTextView.setText(charInfo);
    }
    public String findCharInfo(String charName) {
        for(int i = 0; i < G.CHAR_NAMES.length; i++) {
            if(charName.equals(G.CHAR_NAMES[i])) {
                return "이름 : " + G.CHAR_NAMES[i] + ", 신장 : " + G.CHAR_HEIGHTS[i] + ", "; // 더 필요한 정보를 계속 붙여줌.
            }
        }
        return null;
    }
}