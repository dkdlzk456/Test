package hkit.kr.test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDb extends SQLiteOpenHelper {

    public MyDb(Context context) {
        super(context, "my_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //MYSQL DB와 같은 개념 TABLE 안에 IDX가 오토로 생성되고
        // content 타입을 VARCHAR() 대신 TEXT으로 하면 글자 수 상관없이 속도가 같다.
    db.execSQL("CREATE TABLE memo (idx INTEGER  PRIMARY KEY AUTOINCREMENT, content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertMemo(String content){
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {content};
        db.execSQL("INSERT INTO memo(content) VALUES (?)", args);
        db.close();
    }
    public  List<String> selectMemos(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM memo", null);

        List<String> memos = new ArrayList<>();

        while (cursor.moveToNext()){
            String memo = cursor.getString(1);
            memos.add(memo);
        }
        db.close();
        return memos;
    }
}
