package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.assignment.RegisterActivity;
public class ListOfUsers extends AppCompatActivity {

    private RecyclerView mUsers_RecyclerView;
    private List<User> mUsers;
    RegisterActivity reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_users);
        mUsers_RecyclerView= (RecyclerView) findViewById(R.id.users_recyclerview);
        mUsers_RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUsers= new ArrayList<>();
        for(int i =0; i<100; i++){
            User user= new User();
            user.setFull_name(reg.findViewById(R.id.fullName).toString());
            user.setUsername(reg.findViewById(R.id.userName).toString());
            user.setEmail(reg.findViewById(R.id.email).toString());
            user.setPassword(reg.findViewById(R.id.password).toString());
            user.setPhoneNum(Integer.parseInt(reg.findViewById(R.id.phone).toString()));
            user.setGender(reg.findViewById(R.id.radioGroup).toString());

           mUsers.add(user);
        }
        mUsers_RecyclerView.setAdapter(new UserAdapter(mUsers));
    }
    class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{

        private List<User> mUsers;
        public  UserAdapter(List<User> users){
            super();
            this.mUsers=users;
        }
        @NonNull
        @Override
        public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UserViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

            holder.bind(this.mUsers.get(position));
        }

        @Override
        public int getItemCount() {
            return this.mUsers.size();
        }
    }
    class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView mFullName;
        private TextView mUserName;
        private TextView mEmail;
        private TextView mPassword;
        private TextView mPhone;
        private TextView mGender;
        public UserViewHolder(ViewGroup container){

            super(LayoutInflater.from(ListOfUsers.this).inflate(R.layout.user_list_item, container));
            mFullName = (TextView) itemView.findViewById(R.id.textViewFullName);
            mUserName = (TextView) itemView.findViewById(R.id.textViewUserName);
            mEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
            mPassword = (TextView) itemView.findViewById(R.id.textViewPassword);
            mPhone = (TextView) itemView.findViewById(R.id.textViewPhone);
            mGender = (TextView) itemView.findViewById(R.id.textViewGender);
        }

        public  void bind(User user){
            mFullName.setText(user.getFull_name());
            mUserName.setText(user.getUsername());
            mEmail.setText(user.getEmail());
            mPassword.setText(user.getPassword());
            mPhone.setText(user.getPhoneNum());
            mGender.setText(user.getGender());

        }
    }
}



