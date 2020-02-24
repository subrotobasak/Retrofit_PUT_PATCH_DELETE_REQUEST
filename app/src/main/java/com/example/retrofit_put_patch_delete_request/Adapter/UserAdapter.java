package com.example.retrofit_put_patch_delete_request.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofit_put_patch_delete_request.Model.Model;
import com.example.retrofit_put_patch_delete_request.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<Model> models;

    public UserAdapter(List<Model> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_user_design, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        Model model = models.get(position);
        holder.userIdTv.setText(String.valueOf(model.getUserId()));
        holder.IdTv.setText(String.valueOf(model.getId()));
        holder.titleTv.setText(model.getTitle());
        holder.bodyTv.setText(model.getBody());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userIdTv, IdTv, titleTv, bodyTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userIdTv = itemView.findViewById(R.id.userIdTv);
            IdTv = itemView.findViewById(R.id.IdTv);
            titleTv = itemView.findViewById(R.id.titleIdTv);
            bodyTv = itemView.findViewById(R.id.bodyIdTv);
        }
    }
}

