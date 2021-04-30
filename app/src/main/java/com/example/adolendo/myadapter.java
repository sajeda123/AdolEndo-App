package com.example.frebasetorecycler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;


public class myadapter extends FirebaseRecyclerAdapter<model, com.example.frebasetorecycler.myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model)
    {
       holder.UserId.setText(model.getUserId());
       holder.Comments.setText(model.getCom());
       holder.Date.setText(model.getCurrentDate());
       holder.Time.setText(model.getCurrentTime());

       //-----------------------------Edit------------------//
        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.UserId.getContext())
                        .setContentHolder(new ViewHolder(R.layout.edit_content))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText com=myview.findViewById(R.id.uemail);
                Button submit=myview.findViewById(R.id.usubmit);

                com.setText(model.getCom());
                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();

                        map.put("com",com.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("comments")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });
//--------------------------Delete ---------------------------------//
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.UserId.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Are You Sure to delete comments ...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("comments")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView UserId,Comments,Date,Time,Edit,Delete;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            UserId=(TextView)itemView.findViewById(R.id.userid);
            Comments=(TextView)itemView.findViewById(R.id.comtext);
            Date=(TextView)itemView.findViewById(R.id.date);
            Time=(TextView)itemView.findViewById(R.id.time);

            Edit=(TextView)itemView.findViewById(R.id.edit);
            Delete=(TextView)itemView.findViewById(R.id.delete);
        }
    }
}
