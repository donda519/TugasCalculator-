package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton buttonc, buttonbrackopen,buttonbrackclose;
    MaterialButton buttondivide,bottonmultiply,buttonplus,buttonminus,buttonequals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonac,buttondot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assingId(buttonc, R.id.button_c);
        assingId(buttonbrackopen, R.id.button_open_bracket);
        assingId(buttonbrackclose, R.id.button_Close_bracket);
        assingId(buttondivide, R.id.button_divide);
        assingId(bottonmultiply, R.id.button_multiply);
        assingId(buttonplus, R.id.button_plus);
        assingId(buttonminus, R.id.button_minus);
        assingId(buttonequals, R.id.button_equal);
        assingId(button0, R.id.button_0);
        assingId(button1, R.id.button_1);
        assingId(button2, R.id.button_2);
        assingId(button3, R.id.button_3);
        assingId(button4, R.id.button_4);
        assingId(button5, R.id.button_5);
        assingId(button6, R.id.button_6);
        assingId(button7, R.id.button_7);
        assingId(button8, R.id.button_8);
        assingId(button9, R.id.button_9);
        assingId(buttonac, R.id.button_ac);
        assingId(buttondot, R.id.button_dot);

    }
    void assingId (MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }



    @Override
    public void  onClick(View view){
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if (buttonText.equals("ac")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("c")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalcu0late.length()-1);
        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }

        solutionTv.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }

    }
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript", 1, null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }

    }
}