package alvaro.mt.deweycal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtCal, txtResult;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,  btnAdd, btnSub, btnMul, btnDiv, btnCompute, btnAC, btnBackSpace, btnDot,
            btnC;
    private Boolean dot, opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing
        curr = "";
        res = "";
        dot = false;
        opt = false;
        //textview
        txtCal = findViewById(R.id.txtCal);
        txtResult = findViewById(R.id.txtResult);
        //storing of buttons into variables
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnCompute = findViewById(R.id.btnCompute);
        btnAC = findViewById(R.id.btnAC);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnDot = findViewById(R.id.btnDot);
        btnC = findViewById(R.id.btnC);
        //set up onclick listener don't forget to add the method
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DotChecker();
                DisplayCal();
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllClear();
                DisplayCal();
                DisplayRes();
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackSpace();
                DisplayCal();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot = false;

                if(!curr.isEmpty()) {

                    if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                        BackSpace();
                    }

                    if(opt == false) {
                        curr = curr + " / ";
                        opt = true;
                    }

                }
                DisplayCal();
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot = false;

                if(!curr.isEmpty()) {

                    if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                        BackSpace();
                    }

                    if(opt == false) {
                        curr = curr + " x ";
                        opt = true;
                    }

                }
                DisplayCal();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot = false;

                if(!curr.isEmpty()) {

                    if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                        BackSpace();
                    }

                    if(opt == false) {
                        curr = curr + " - ";
                        opt = true;
                    }

                }
                DisplayCal();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot = false;

                if(!curr.isEmpty()) {

                    if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                        BackSpace();
                    }

                    if(opt == false) {
                        curr = curr + " + ";
                        opt = true;
                    }

                }
                DisplayCal();
            }
        });

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Compute();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearE();
                DisplayCal();
                DisplayRes();
            }
        });

    }

    // methods seperated from oncreate method
    public void onClick(View view) {

        int id = view.getId();

        if(id == R.id.btn0) {
            curr = curr + "0";
            DisplayCal();
        }

        if(id == R.id.btn1) {
            curr = curr + "1";
            DisplayCal();
        }

        if(id == R.id.btn2) {
            curr = curr + "2";
            DisplayCal();
        }

        if(id == R.id.btn3) {
            curr = curr + "3";
            DisplayCal();
        }

        if(id == R.id.btn4) {
            curr = curr + "4";
            DisplayCal();
        }

        if(id == R.id.btn5) {
            curr = curr + "5";
            DisplayCal();
        }

        if(id == R.id.btn6) {
            curr = curr + "6";
            DisplayCal();
        }

        if(id == R.id.btn7) {
            curr = curr + "7";
            DisplayCal();
        }

        if(id == R.id.btn8) {
            curr = curr + "8";
            DisplayCal();
        }

        if(id == R.id.btn9) {
            curr = curr + "9";
            DisplayCal();
        }

    }


    public void DotChecker() {

        if(curr.isEmpty()) {
            curr = "0.";
            dot = true;
        }

        if(!curr.isEmpty()) {

            if(dot == false) {
                curr = curr + ".";
                dot = true;
            }

        }
    }


    public void Compute() {

        if(opt == true && !curr.substring(curr.length()-1, curr.length()).equals(" ")) {

            String [] tokens = curr.split(" ");

            switch (tokens[1].charAt(0)) {

                case '+':
                    res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                    break;
                case '-':
                    res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                    break;
                case 'x':
                    res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                    break;
                case '/':
                    res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                    break;
            }
            DisplayRes();
        }

    }

    public void ClearE() {

        if(curr.equals("")) {
            Toast.makeText(getApplicationContext(), "There is no Input", Toast.LENGTH_SHORT).show();
            txtCal.requestFocus();
            return;
        }

        if(!curr.isEmpty()) {

            String[] input = curr.split(" ");
            input = Arrays.copyOf(input, input.length - 1);
            curr = String.join(" ", input) + " ";
            res = "0";

        }

        else {
            Toast.makeText(getApplicationContext(), "There is no Input", Toast.LENGTH_SHORT).show();
            txtCal.requestFocus();
            return;
        }

    }


    public void DisplayCal() {
        //hey
        txtCal.setText(curr);
    }

    public void DisplayRes() {
        //hello
        txtResult.setText(res);
    }

    public void AllClear() {
        if(!curr.isEmpty()) {
            curr = "";
            res = "";
            dot = false;
            opt = false;
        }

        if(curr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "There is no Input", Toast.LENGTH_SHORT).show();
            txtCal.requestFocus();
            return;
        }
    }

    public void BackSpace() {

        if(!curr.isEmpty()) {

            if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                dot = false;
            }

            if(curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length()-3);
                opt = false;
            }

            else {
            curr = curr.substring(0, curr.length()-1);
            }

        }

        if(curr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "There is no Input", Toast.LENGTH_SHORT).show();
            txtCal.requestFocus();
            return;
        }

    }

}
