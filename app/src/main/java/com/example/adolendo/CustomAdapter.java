package com.example.adolendo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public CustomAdapter(Activity context,List<Student> studentList) {
        super(context,R.layout.activity_par_profile_,studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.activity_par_profile_,null,true);
        Student student=studentList.get(position);

        TextView t1=view.findViewById(R.id.text_name);
        TextView t2=view.findViewById(R.id.text_ins);
        TextView t3=view.findViewById(R.id.text_class);
        TextView t4=view.findViewById(R.id.text_sec);
        TextView t5=view.findViewById(R.id.text_roll);
        TextView t6=view.findViewById(R.id.text_email);
        TextView t7=view.findViewById(R.id.text_mobile);
        TextView t8=view.findViewById(R.id.text_classTeacher);
        TextView t9=view.findViewById(R.id.classTeacherMobile);
        TextView t10=view.findViewById(R.id.text_teacherEmail);
        TextView t11=view.findViewById(R.id.text_gurdian);
        TextView t12=view.findViewById(R.id.text_rel);
        TextView t13=view.findViewById(R.id.text_gurdiansEmail);
        TextView t14=view.findViewById(R.id.text_dob);

        t1.setText("Name : "+student.getName());
        t2.setText("Institution Name : "+student.getInstitutionName());
        t3.setText("Class : "+student.getClassName());
        t4.setText("Section : "+student.getSection());
        t5.setText("Roll : "+student.getRoll());
        t6.setText("Email : "+student.getEmail());
        t7.setText("Mobile Number : "+student.getMobileNumber());
        t8.setText("Class Teacher Name : "+student.getClassTeacherName());
        t9.setText("Class Teacher Mobile No : "+student.getClassTeacherMobile());
        t10.setText("Class Teacher Email/WhatsApp : "+student.getClassTeacherEmail());
        t11.setText("Guardian Name : "+student.getGurdianName());
        t12.setText("Relationship With Guardian : "+student.getGurdianRelation());
        t13.setText("Guardian's Email/WhatsApp : "+student.getGurdianEmail());
        t14.setText("Date Of Birth : "+student.getDateOfBirth());


        return view;
    }
}
