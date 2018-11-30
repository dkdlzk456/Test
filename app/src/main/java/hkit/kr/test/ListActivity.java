package hkit.kr.test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    //List<String> secrets;
    int sex;
    int blood1;
    int j;
    int gender1;
    int blood2;
    String gender;
    String blood;
    String[] secrets = {
            "미사카 미코토",
            "카드챕터 체리-지수",
            "미나 미나츠"

    };
  //  List<String> secrets;
    ArrayAdapter<String> memeoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listView);
        Intent intent = getIntent();



        gender = intent.getStringExtra("gender");
        blood = intent.getStringExtra("blood");
       // secrets = findCharacters(gender,blood);
        memeoAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, secrets);
        listView.setAdapter(memeoAdapter);
        listView.setOnItemClickListener(listItemListener);

        ArrayAdapter<String> secretAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, secrets);

        sex = Integer.valueOf(gender);
        blood1 = Integer.valueOf(blood);
       j= matchBlood(0,0,j);
    }
    public int matchBlood(int gender1, int blood2, int j) {
        for(int h= 0; h<2; h++) {
            for (int i = 0; i < 3; i++) {
                blood2 = i;
                gender1 = h;
                if (gender1== 0 && gender1 == sex) {
                    if (blood2 == blood1 && blood1 == 0) {
                        j = 0;
                    } else if (blood2 == blood1 && blood1 == 1) {
                        j = 1;
                    } else if (blood2 == blood1 && blood1 == 2) {
                        j = 2;
                    } else if (blood2 == blood1 && blood1 == 3) {
                        j = 3;
                    }
                }else if (gender1== 1 && gender1 == sex) {
                    if (blood2 == blood1 && blood1 == 0) {
                        j = 0;
                    } else if (blood2 == blood1 && blood1 == 1) {
                        j = 1;
                    } else if (blood2 == blood1 && blood1 == 2) {
                        j = 2;
                    } else if (blood2 == blood1 && blood1 == 3) {
                        j = 3;
                    }
                }
            }
        }
        return j;
    }



    AdapterView.OnItemClickListener listItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //    String charName = secrets.get(position);
          //  Intent intent = new Intent(getBaseContext(), CharInfoActivity.class);
         //   intent.putExtra("charName", charName);
        //    startActivity(intent);
            if (j == 0) {
                String charName = secrets[position];
                Intent intent = new Intent(getBaseContext(), Ani1Activity.class);
                intent.putExtra("charName", charName);
                startActivity(intent);
            }
            else if (j == 1) {
                String charName1 = secrets[position];
                Intent intent = new Intent(getBaseContext(), Ani2Activity.class);
                intent.putExtra("charName1", charName1);
                startActivity(intent);
            }
            else if (j == 2) {
                String charName2 = secrets[position];
                Intent intent = new Intent(getBaseContext(), Ani3Activity.class);
                intent.putExtra("charName2", charName2);
                startActivity(intent);
            }
//            if (position == 0) {
//                Intent intent = new Intent(getBaseContext(), Ani1Activity.class);
//                startActivity(intent);
//            } else if (position == 1) {
//                Intent intent = new Intent(getBaseContext(), Ani2Activity.class);
//                startActivity(intent);
//            }else if (position == 2) {
//                Intent intent = new Intent(getBaseContext(), Ani3Activity.class);
//                startActivity(intent);
//            }
        }
    };


    }



