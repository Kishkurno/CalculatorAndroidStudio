package com.example.mobilelab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Boolean isNew = true;
    String operator = "";
    String oldNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        View oneBt = findViewById(R.id.bu1);

    }

    public void clickNumber(View view){
        if(isNew)
            editText.setText("");
        isNew=false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                if(zeroIsFirst(number) && number.length()==1){
                    number = number.substring(1);
                }
                number = number+"1";break;
            case R.id.bu2:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"2";break;
            case R.id.bu3:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"3";break;
            case R.id.bu4:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"4";break;
            case R.id.bu5:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"5";break;
            case R.id.bu6:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"6";break;
            case R.id.bu7:
                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"7";break;
            case R.id.bu8:

                if(zeroIsFirst(number)&& number.length()==1){
                number = number.substring(1);
            }
                number = number+"8";break;
            case R.id.bu9:

                if(zeroIsFirst(number)&& number.length()==1){
                    number = number.substring(1);
                }
                number = number+"9";break;


                case R.id.bu0:

                if(numberIsZero(number) && number.length()==1){
                    number = "0";
                }else{

                    number = number+"0";
                }
                break;

            case R.id.buDot:
                if(dotIsPresent(number)){

                }else
                if(zeroIsFirst(number)){
                    number="0.";
                }
                else{
                    number = number+".";
                }
                break;

            case R.id.buPlusMinus:
                if(numberIsZero(number)){
                    number="0";  // ошибочка
                }else{
                    if(minusIsPresent(number)){
                        number=number.substring(1);
                    }else{
                        number = "-"+number;
                    }
                }



                break;
        }
        editText.setText(number);
    }

    public void operation(View view){
        isNew=true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.buMinus: operator= "-";break;
            case R.id.buPlus: operator= "+";break;
            case R.id.buDivite: operator= "/";break;
            case R.id.buMultiply: operator= "*";break;
        }
    }

    public void clickResult (View view){
        String newNumber =editText.getText().toString();
        Double result = 0.0;

        if( Double.parseDouble(newNumber) < 0.00000001 && operator=="/"
                || newNumber.equals("") && operator=="/"){
            editText.setText("error");
            Toast.makeText(MainActivity.this, "Error. Dividing on zero!", Toast.LENGTH_SHORT).show();
       }else{
            switch (operator){
                case "-": result= Double.parseDouble(oldNumber) - Double.parseDouble(newNumber) ;break;
                case "+": result= Double.parseDouble(oldNumber) + Double.parseDouble(newNumber) ;break;
                case "/": result= Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) ;break;
                case "*": result= Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) ;break;
            }
            editText.setText(result+"");
       }
    }

    public void acClick (View view){
        Animation anim = null;
        anim= AnimationUtils.loadAnimation(this, R.anim.scale);
        View buAC = findViewById(R.id.buAC); // Replace 'your_button_id' with the actual ID
        buAC.startAnimation(anim);

        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent(String number){

        if(number.indexOf(".") == -1){
            return false;
        } else{

            return true;
        }
    }

    public boolean minusIsPresent(String number){
        if(number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }}

    public void clickpPersent(View view){

        if(operator == ""){
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number)/100;
            number = temp+"";
            editText.setText(number);
        }else{
            String newNumber =editText.getText().toString();
            Double result = 0.0;
            switch (operator){
                case "+": result= Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) *Double.parseDouble(newNumber)/100;break;
                case "-": result= Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) *Double.parseDouble(newNumber)/100;break;
                case "/": result= Double.parseDouble(oldNumber) / (Double.parseDouble(oldNumber) *Double.parseDouble(newNumber)/100);break;
                case "*": result= Double.parseDouble(oldNumber) * ( Double.parseDouble(oldNumber) *Double.parseDouble(newNumber)/100) ;break;
            }

            editText.setText(result+"");
            operator="";
        }

    }

    public boolean numberIsZero(String number){
        if(number.equals("0") || number.equals("")  ){
            return true;
        }else{
            return false;
        }
    }

    private boolean zeroIsFirst(String number){
        if(number.equals("")){
            return true;
        }
        if(number.charAt(0) == '0') {
            return true;
        }else{
            return false;
        }
    }

    private void delFirst(String number){

            number = number.substring(1);

    }
    //public void openActivity2(View view) {
       //Intent intent = new Intent(this, MainActivity2.class);
        // Получите текущее значение EditText
        //String currentText = editText.getText().toString();

        // Добавьте значения в Intent
        //intent.putExtra("currentText", currentText);
        //intent.putExtra("isNew", isNew);
        //intent.putExtra("operator", operator);
        //intent.putExtra("oldNumber", oldNumber);
       // intent.putExtra("editText", editText.getText().toString());
     //   startActivity(intent);
       // startActivity(intent);
    //}

    public void navigateBackD(View view) {
        finishAffinity();
    }
    public void navigateBack(View view) {
        finish();
    }
}