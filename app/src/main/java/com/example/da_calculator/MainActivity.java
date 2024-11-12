package com.example.da_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button numberZero, numberOne, numberTwo,
            numberThree, numberFour, numberFive,
            numberSix, numberSeven, numberEight,
            numberNine, equals,
            subtraction, clearField,
            addition, point, multiplication, divide;

    private ImageButton backspaceButton;

    private TextView txtExpression, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IniciateComponents();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        equals.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        addition.setOnClickListener(this);
        point.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        divide.setOnClickListener(this);

        clearField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        backspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtExpression = findViewById(R.id.txt_expression);
                String string = txtExpression.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String inside_expression = string.substring(var0,var1);
                    txtExpression.setText(inside_expression);
                }
                txtResult.setText("");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression inside_expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = inside_expression.evaluate();
                    long long_result = (long) result;

                    if (result == (double) long_result) {
                        txtResult.setText((CharSequence) String.valueOf(long_result));
                    } else {
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                }
                catch(Exception e) {
                }
            }
        });

    }

    private void IniciateComponents() {
        numberZero = findViewById(R.id.number_zero);
        numberOne = findViewById(R.id.number_one);
        numberTwo = findViewById(R.id.number_two);
        numberThree = findViewById(R.id.number_three);
        numberFour = findViewById(R.id.number_four);
        numberFive = findViewById(R.id.number_five);
        numberSix = findViewById(R.id.number_six);
        numberSeven = findViewById(R.id.number_seven);
        numberEight = findViewById(R.id.number_eight);
        numberNine = findViewById(R.id.number_nine);
        addition = findViewById(R.id.bt_sum);
        subtraction = findViewById(R.id.bt_subtraction);
        multiplication = findViewById(R.id.bt_multi);
        divide = findViewById(R.id.bt_divide);
        point = findViewById(R.id.bt_point);
        equals = findViewById(R.id.bt_equals);
        clearField = findViewById(R.id.bt_clear);
        backspaceButton = findViewById(R.id.bt_backspace);
        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);
    }

    public void AddOneExpression(String value_state, boolean clean_data) {
        if (txtResult.getText().equals("")) {
            txtResult.setText("");
        }

        if (clean_data) {
            txtResult.setText("");
            txtExpression.append(value_state);
        } else {
            txtExpression.append(txtResult.getText());
            txtExpression.append(value_state);
            txtResult.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.number_zero:
                AddOneExpression("0", true);
                break;

            case R.id.number_one:
                AddOneExpression("1", true);
                break;

            case R.id.number_two:
                AddOneExpression("2", true);
                break;

            case R.id.number_three:
                AddOneExpression("3", true);
                break;

            case R.id.number_four:
                AddOneExpression("4", true);
                break;

            case R.id.number_five:
                AddOneExpression("5", true);
                break;

            case R.id.number_six:
                AddOneExpression("6", true);
                break;

            case R.id.number_seven:
                AddOneExpression("7", true);
                break;

            case R.id.number_eight:
                AddOneExpression("8", true);
                break;

            case R.id.number_nine:
                AddOneExpression("9", true);
                break;

            case R.id.bt_point:
                AddOneExpression(".", true);
                break;

            case R.id.bt_sum:
                AddOneExpression("+", false);
                break;

            case R.id.bt_subtraction:
                AddOneExpression("-", false);
                break;

            case R.id.bt_multi:
                AddOneExpression("*", false);
                break;

            case R.id.bt_divide:
                AddOneExpression("/", false);
                break;
        }
    }
}