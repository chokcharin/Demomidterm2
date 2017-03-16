package phromphong.demomidterm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListView extends BaseAdapter {

    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<TodoList>myTodolist;
    public MyListView(Activity activity,ArrayList<TodoList>myTodolist){
        this.myTodolist = myTodolist;this.activity = activity;inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return myTodolist.size();
    }
    public Object getItem(int position) {
        return myTodolist.get(position);
    }
    public long getItemId(int position) {
        return myTodolist.get(position).getId();
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.listview_text); TodoList todoList = myTodolist.get(position); textView.setText(todoList.getTodotext());
        return v;
    }
}
