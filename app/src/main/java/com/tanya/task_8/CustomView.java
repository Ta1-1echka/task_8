package com.tanya.task_8;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomView extends LinearLayout {

    EditText editText;
    TextView textView;
    Button button;


    public CustomView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.compound, this, true);
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        editText = (EditText) getChildAt(0);
        textView = (TextView) getChildAt(1);
        button = (Button) getChildAt(2);
        editText.setBackgroundResource(R.drawable.edit_text_style);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                    editText.setBackgroundResource(R.drawable.edit_text_wrong);
                    textView.setText("Your email is not valid");
                } else Toast.makeText(context, "Valid email", Toast.LENGTH_LONG).show();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editText.setBackgroundResource(R.drawable.edit_text_style);
                textView.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}
