package com.vijayapps.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

    private List<TodoItem> todoItems;

    public TodoListAdapter(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View todoView = inflater.inflate(R.layout.todo_text, parent, false);

        ViewHolder viewHolder = new ViewHolder(todoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem todoItem = todoItems.get(position);

        holder.todoTextView.setText(todoItem.getDescription());
        holder.todoCheckBox.setChecked(todoItem.isCompleted());
        holder.todoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                todoItem.setCompleted(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView todoTextView;
        public CheckBox todoCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);

            todoTextView = itemView.findViewById(R.id.todo_text);
            todoCheckBox = itemView.findViewById(R.id.todo_checkbox);
        }
    }
}
