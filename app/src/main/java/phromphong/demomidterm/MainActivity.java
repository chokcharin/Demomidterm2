package phromphong.demomidterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class MainActivity extends AppCompatActivity {
   public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.todo_listview);
        TodoListDao todoListDao = new TodoListDao(getApplicationContext());
        todoListDao.open();

        ArrayList<TodoList>myList = todoListDao.getAlltodoList();
        final MyListView adapter = new MyListView(this,myList);
        listView.setAdapter(adapter);
        todoListDao.close();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),String.valueOf(adapter.getItemId(position)),
                   //   Toast.LENGTH_SHORT ).show();
                Intent editIntent = new Intent(getApplicationContext(),EditActivity.class);
                editIntent.putExtra("editTodoList", (Serializable) adapter.getItem(position));
                startActivity(editIntent);
            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_add_new_menu){
            Intent addNewIntent = new Intent(this,AddDataActivity.class);
            startActivity(addNewIntent);
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
    protected void onResume() {
       super.onResume();
        TodoListDao todoListDao = new TodoListDao(getApplicationContext());
        todoListDao.open();
        ArrayList<TodoList> myList = todoListDao.getAlltodoList();
        MyListView adapter = new MyListView(this,myList);
        listView.setAdapter(adapter);
        todoListDao.close();



    }
}
