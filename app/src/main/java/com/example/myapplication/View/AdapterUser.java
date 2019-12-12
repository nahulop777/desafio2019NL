package com.example.myapplication.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterUser extends RecyclerView.Adapter {

    private List<User> userList;
    private UserAdapterListener userAdapterListener;

    public AdapterUser(List<User> userList, UserAdapterListener userAdapterListener) {
        this.userList = userList;
        this.userAdapterListener = userAdapterListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celdausuario, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = userList.get(position);
        UserViewHolder userViewHolder = (UserViewHolder) holder;
        userViewHolder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.userFoto)
        ImageView ImageViewUser;
        @BindView(R.id.username)
        TextView textViewUserItem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = userList.get(getAdapterPosition());
                    userAdapterListener.usuarioElegido(user);
                }
            });

        }
        public void bind(User user){
            Glide.with(itemView).load(user.getPicture().getLarge()).into(ImageViewUser);
            textViewUserItem.setText(user.getLogin().getUsername());

        }
    }

    public interface UserAdapterListener {
        void usuarioElegido(User user);
    }
}

