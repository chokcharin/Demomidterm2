package phromphong.demomidterm;

import android.text.Editable;

import java.io.Serializable;

/**
 * Created by phrompongkhagtes on 2/28/2017 AD.
 */

public class TodoList implements Serializable{
    public int id;
    public   String todotext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodotext() {
        return todotext;
    }

    public void setTodotext(String todotext) {
        this.todotext = todotext;
    }


}
