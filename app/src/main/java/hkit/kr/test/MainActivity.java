package hkit.kr.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup1;
    Button button;
    RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGourp1);
        radioGroup2 = findViewById(R.id.radioGroup2);
      //  editText = findViewById(R.id.editText);
        button = findViewById(R.id.okbutton);
        button.setOnClickListener(onClickListener);
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), ListActivity.class);

             intent.putExtra("gender", getGender() + "");
            intent.putExtra("blood", getBlood()+"");
            startActivity(intent);

         //   int month = Integer.valueOf("gender"); //문자를 숫자로 바꿔준다.
        }
    };

    public int getGender() {
        if(radioGroup1.getCheckedRadioButtonId() == R.id.manBox) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getBlood() {
        if (radioGroup2.getCheckedRadioButtonId() == R.id.Abox) {
            return 0;
        }
        else if (radioGroup2.getCheckedRadioButtonId() == R.id.Bbox) {
            return 1;
        }
        else if (radioGroup2.getCheckedRadioButtonId() == R.id.Obox) {
            return 2;
        }
        else  return 3;


    }
}