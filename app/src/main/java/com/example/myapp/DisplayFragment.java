package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {
    private TextView tvName, tvAge, tvGrade, tvMajor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        tvGrade = view.findViewById(R.id.tvGrade);
        tvMajor = view.findViewById(R.id.tvMajor);
        return view;
    }

    public void updateStudentInfo(Student student) {
        tvName.setText("Name: " + student.getName());
        tvAge.setText("Age: " + student.getAge());
        tvGrade.setText("Grade: " + student.getGrade());
        tvMajor.setText("Major: " + student.getMajor());
    }
}
