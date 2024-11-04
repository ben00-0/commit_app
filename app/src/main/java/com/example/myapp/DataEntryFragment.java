package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class DataEntryFragment extends Fragment {
    private EditText etName, etAge, etGrade, etMajor;
    private OnDataPass dataPasser;

    public interface OnDataPass {
        void onDataPass(Student student);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);
        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etGrade = view.findViewById(R.id.etGrade);
        etMajor = view.findViewById(R.id.etMajor);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> submitData());
        return view;
    }

    private void submitData() {
        String name = etName.getText().toString();
        String ageStr = etAge.getText().toString();
        String gradeStr = etGrade.getText().toString();
        String major = etMajor.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(gradeStr)) {
            Toast.makeText(getActivity(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        int grade = Integer.parseInt(gradeStr);

        if (age <= 0 || grade < 0 || grade > 100) {
            Toast.makeText(getActivity(), "Please enter valid age and grade", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(name, age, grade, major);
        dataPasser.onDataPass(student);
        clearFields();
    }

    private void clearFields() {
        etName.setText("");
        etAge.setText("");
        etGrade.setText("");
        etMajor.setText("");
    }
}
