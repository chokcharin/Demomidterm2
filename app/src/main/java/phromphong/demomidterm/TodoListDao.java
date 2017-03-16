package phromphong.demomidterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 2/28/2017 AD.
 */

public class TodoListDao {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDao(Context context) {
       // this.database = database;
        dbHelper = new DbHelper(context);
    }
    public void open(){
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public ArrayList<TodoList> getAlltodoList(){
        ArrayList<TodoList> todolist = new ArrayList<TodoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM todo_list;",null);
        cursor.moveToFirst();
        TodoList todoList1;
        while(!cursor.isAfterLast()){
            todoList1 = new TodoList();
            todoList1.setId(cursor.getInt(0));
            todoList1.setTodotext(cursor.getString(1));
            todolist.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();
        return  todolist;
    }
    public void add(TodoList todoList){
        TodoList newTodoList = new TodoList();
        newTodoList = todoList;
        ContentValues values = new ContentValues();
        values.put("todo_text",newTodoList.getTodotext());
        this.database.insert("todo_list",null,values);
        Log.d("Todo List Demo:::","Add OK");
    }
    public void update(TodoList todoList){
        TodoList updateTodoList = todoList;
        ContentValues values = new ContentValues();
        values.put("todo_text",updateTodoList.getTodotext());
        values.put("id",updateTodoList.getId());
        String where = "id=" + updateTodoList.getId();
        this.database.update("todo_list",values,where,null);
       // this.database.update("todo_list",values,where,null);


    }
    public void delete(TodoList todoList){
        TodoList delTodolist = todoList;
        String sqlText = "DELETE FROM todo_list WHERE id=" + delTodolist.getId();
        this.database.execSQL(sqlText);
    }
}
