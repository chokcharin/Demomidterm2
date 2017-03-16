package phromphong.demomidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");

        final EditText editText = (EditText)findViewById(R.id.edit_editText);
        editText.setText(editTodoList.getTodotext());

        Button editBtn = (Button)findViewById(R.id.button_edit);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();
                eTodoList.setId(editTodoList.getId());
                eTodoList.setTodotext(String.valueOf(editText.getText()));
                //eTodoList.setTodotext(String.valueOf(editText.getText()));

               TodoListDao todoListDao = new TodoListDao(getApplicationContext());
                todoListDao.open();
                todoListDao.update(eTodoList);
                todoListDao.close();
                finish();
            }
        });
        Button delBtn = (Button) findViewById(R.id.button_delete);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListDao todoListDAODel = new TodoListDao(getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();
                finish();
            }
        });
    }

}
