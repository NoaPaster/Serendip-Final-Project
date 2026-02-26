package com.example.serendipfinalproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private final List<User> users;

    public UsersAdapter(@NonNull List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);

        String name = safe(user.getName());
        String email = safe(user.getEmail());
        String phone = safe(user.getPhone());
        String initials = firstLetter(name);

        holder.nameText.setText(name);
        holder.emailText.setText(email);
        holder.initialsText.setText(initials);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProfileActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("initials", initials);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        final TextView initialsText;
        final TextView nameText;
        final TextView emailText;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            initialsText = itemView.findViewById(R.id.initialsText);
            nameText = itemView.findViewById(R.id.nameText);
            emailText = itemView.findViewById(R.id.emailText);
        }
    }

    private static String safe(String s) {
        return (s == null) ? "" : s.trim();
    }

    private static String firstLetter(String name) {
        if (name == null) return "?";
        name = name.trim();
        if (name.isEmpty()) return "?";
        return String.valueOf(Character.toUpperCase(name.charAt(0)));
    }
}
