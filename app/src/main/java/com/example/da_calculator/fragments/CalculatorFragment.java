package com.example.da_calculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.da_calculator.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private Button numberZero, numberOne, numberTwo,
            numberThree, numberFour, numberFive,
            numberSix, numberSeven, numberEight,
            numberNine, equals,
            subtraction, clearField,
            addition, point, multiplication, divide, backspaceButton;

    private TextView txtExpression, txtResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        // Inicializar componentes
        IniciateComponents(view);

        // Definir listeners
        setOnClickListeners();

        return view;
    }

    private void IniciateComponents(View view) {
        numberZero = view.findViewById(R.id.number_zero);
        numberOne = view.findViewById(R.id.number_one);
        numberTwo = view.findViewById(R.id.number_two);
        numberThree = view.findViewById(R.id.number_three);
        numberFour = view.findViewById(R.id.number_four);
        numberFive = view.findViewById(R.id.number_five);
        numberSix = view.findViewById(R.id.number_six);
        numberSeven = view.findViewById(R.id.number_seven);
        numberEight = view.findViewById(R.id.number_eight);
        numberNine = view.findViewById(R.id.number_nine);
        addition = view.findViewById(R.id.bt_sum);
        subtraction = view.findViewById(R.id.bt_subtraction);
        multiplication = view.findViewById(R.id.bt_multi);
        divide = view.findViewById(R.id.bt_divide);
        point = view.findViewById(R.id.bt_point);
        equals = view.findViewById(R.id.bt_equals);
        clearField = view.findViewById(R.id.bt_clear);
        backspaceButton = view.findViewById(R.id.bt_backspace);
        txtExpression = view.findViewById(R.id.txt_expression);
        txtResult = view.findViewById(R.id.txt_result);
    }

    private void setOnClickListeners() {
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

        clearField.setOnClickListener(v -> {
            txtExpression.setText("");
            txtResult.setText("");
        });

        backspaceButton.setOnClickListener(v -> {
            String string = txtExpression.getText().toString();
            if (!string.isEmpty()) {
                txtExpression.setText(string.substring(0, string.length() - 1));
            }
            txtResult.setText("");
        });

        equals.setOnClickListener(v -> {
            try {
                Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                double result = expression.evaluate();
                long longResult = (long) result;

                if (result == (double) longResult) {
                    txtResult.setText(String.valueOf(longResult));
                } else {
                    txtResult.setText(String.valueOf(result));
                }
            } catch (Exception e) {
                txtResult.setText("Error");
            }
        });
    }

    public void AddOneExpression(String value_state, boolean isOperator) {
        if (!txtResult.getText().toString().isEmpty()) {
            txtExpression.setText("");
            txtExpression.setText(txtResult.getText().toString());
            txtResult.setText("");
        }

        if (isOperator && txtExpression.getText().toString().isEmpty()) {
            return;
        }

        txtExpression.append(value_state);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.number_zero:
                AddOneExpression("0", false);
                break;
            case R.id.number_one:
                AddOneExpression("1", false);
                break;
            case R.id.number_two:
                AddOneExpression("2", false);
                break;
            case R.id.number_three:
                AddOneExpression("3", false);
                break;
            case R.id.number_four:
                AddOneExpression("4", false);
                break;
            case R.id.number_five:
                AddOneExpression("5", false);
                break;
            case R.id.number_six:
                AddOneExpression("6", false);
                break;
            case R.id.number_seven:
                AddOneExpression("7", false);
                break;
            case R.id.number_eight:
                AddOneExpression("8", false);
                break;
            case R.id.number_nine:
                AddOneExpression("9", false);
                break;
            case R.id.bt_point:
                AddOneExpression(".", false);
                break;
            case R.id.bt_sum:
                AddOneExpression("+", true);
                break;
            case R.id.bt_subtraction:
                AddOneExpression("-", true);
                break;
            case R.id.bt_multi:
                AddOneExpression("*", true);
                break;
            case R.id.bt_divide:
                AddOneExpression("/", true);
                break;
        }
    }
}
