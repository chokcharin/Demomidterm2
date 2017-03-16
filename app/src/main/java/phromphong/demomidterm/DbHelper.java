package phromphong.demomidterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by phrompongkhagtes on 2/28/2017 AD.
 */

public class DbHelper extends SQLiteOpenHelper{
    private static final String databasename = "todolist.sqlite";
    private static final int databaseversion = 1;
    Context myContext;
    private static final String tableCreateSql = "CREATE TABLE todo_list("+"id INTEGER PRIMARY KEY AUTOINCREMENT,"+"todo_text TEXT"+");";
    public DbHelper(Context context) {
        super(context, databasename, null,databaseversion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSql);
        String insertData1 = "INSERT INTO todo_list (todo_text) VALUES ('Chopper_1')";
        String insertData2 = "INSERT INTO todo_list (todo_text) VALUES ('Chopper_2')";
        String insertData3 = "INSERT INTO todo_list (todo_text) VALUES ('Chopper_3')";
        String insertData4 = "INSERT INTO todo_list (todo_text) VALUES ('Chopper_4')";
        String insertData5 = "INSERT INTO todo_list (todo_text) VALUES ('Chopper_5')";
        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);
        db.execSQL(insertData4);
        db.execSQL(insertData5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
