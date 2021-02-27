package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    final int TOTAL_SCORE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton(View view) {
        String toastMessage = null;

        //Validation for the first question.
        // CheckBox 1 and CheckBox 2 should be checked and the other two checkbox should be not checked.
        CheckBox answerCheckbox1 = findViewById(R.id.checkbox1);
        CheckBox answerCheckbox2 = findViewById(R.id.checkbox2);
        CheckBox answerCheckbox3 = findViewById(R.id.checkbox3);
        CheckBox answerCheckbox4 = findViewById(R.id.checkbox4);

        if (answerCheckbox1.isChecked() && answerCheckbox2.isChecked()) {
            if (!answerCheckbox3.isChecked() && !answerCheckbox4.isChecked()) {
                score += 1;
            }
        }

        // Validation for the second question
        // The first radioButton should be clicked
        RadioButton answerRadio = (RadioButton) findViewById(R.id.radio_button1);
        if (answerRadio.isChecked()) {
            score += 1;
        }

        //Validation for the Third Question
        //Checking the answer IBM from the input received
        EditText answerEdit = (EditText) findViewById(R.id.editText);
        if (answerEdit.getText().toString().trim().toUpperCase().equals("IBM")) {
            score += 1;
        }

        //Validation for the Fourth Question
        //First radioButton should be clicked
        RadioButton answerRadio4 = (RadioButton) findViewById(R.id.radio_button4_1);
        if (answerRadio4.isChecked()) {
            score += 1;
        }

        //Validation for the Fifth Question
        //CheckBox 1 & 4 must be clicked and the CheckBox 3 & 2 should not clicked.
        CheckBox answerCheckbox5_1 = findViewById(R.id.checkbox5_1);
        CheckBox answerCheckbox5_2 = findViewById(R.id.checkbox5_2);
        CheckBox answerCheckbox5_3 = findViewById(R.id.checkbox5_3);
        CheckBox answerCheckbox5_4 = findViewById(R.id.checkbox5_4);

        if (answerCheckbox5_1.isChecked() && answerCheckbox5_4.isChecked()) {
            if (!answerCheckbox5_3.isChecked() && !answerCheckbox5_2.isChecked()) {
                score += 1;
            }
        }

        //Validation to display message when the Submit Button is clicked.
        if (TOTAL_SCORE == score) {
            toastMessage = getString(R.string.toastMessageString1) + getString(R.string.toastMessagestring3);
        } else if (score > 0) {
            toastMessage = "You Got " + score + "/5." + getString(R.string.toastMessageString2);
        } else {
            toastMessage = getString(R.string.toastMessageString3) + getString(R.string.toastMessageString2);
        }
        Toast showToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        showToast.show();

        //Resetting the score
        score = 0;
    }
}