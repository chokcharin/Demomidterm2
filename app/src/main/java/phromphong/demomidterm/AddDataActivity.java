package phromphong.demomidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_activity);
        final EditText newTodoListText = (EditText)findViewById(R.id.editText);
        final Button newTodoListButton = (Button)findViewById(R.id.btnAddNewTask);

        newTodoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList todoList = new TodoList();
                todoList.setTodotext(String.valueOf(newTodoListText.getText()));
                TodoListDao todoListDao = new TodoListDao(getApplicationContext());
                todoListDao.open();
                todoListDao.add(todoList);
                todoListDao.close();
                finish();

            }
        });

    }
}
