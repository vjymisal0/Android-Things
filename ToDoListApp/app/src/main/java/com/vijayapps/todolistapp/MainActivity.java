
package com.vijayapps.todolistapp;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.RecyclerView;
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.text.InputType;
    import android.view.View;
    import android.widget.CompoundButton;
    import android.widget.EditText;
    import com.google.android.material.floatingactionbutton.FloatingActionButton;
    import java.util.ArrayList;
    import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<TodoItem> todoItems;
    private RecyclerView todoList;
    private TodoListAdapter todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoItems = new ArrayList<>();
        todoList = findViewById(R.id.todo_list);
        todoListAdapter = new TodoListAdapter(todoItems);
        todoList.setAdapter(todoListAdapter);

        FloatingActionButton addTodoButton = findViewById(R.id.add_todo_button);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddTodoDialog();
            }
        });
    }

    private void showAddTodoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Todo Item");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String description = input.getText().toString();
                TodoItem todoItem = new TodoItem(description, false);
                todoItems.add(todoItem);
                todoListAdapter.notifyItemInserted(todoItems.size() - 1);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
