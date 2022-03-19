import java.awt.Color;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.*;

public class Calculator extends JFrame{

    private JFrame frame;
    private JLabel label;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDot;
    private JButton buttonEqual;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMul;
    private JButton buttonDiv;
    private JButton buttonMod;
    private JButton buttonPower;
    private JButton buttonRoot;
    private JButton buttonFact;
    private JButton buttonABS;
    private JButton buttonNEG;
    private JButton buttonDEL;
    private JButton buttonAC;

    static String CurrentAction = "";
    static String Prev = "0.0";
    static boolean GetNumber = false;

    public Calculator(){
        //Label creation
        LabelCreation();

        //Buttons creation.
        ButtonsCreation();

        // Frame creation.
        FrameCreation();

        //Create the buttons and label.
        ElementsCreation();

        //Set the buttons actions
        SetButtonsActions();

    }

    public void FrameCreation(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(305,545);
        frame.setVisible(true);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(40,40,43));
    }

    public void LabelCreation(){
        label = new JLabel();
        label.setBounds(10,25,270,50);
        label.setText("");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(Color.orange);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.black,2));
        label.setVisible(true);
    }

    public void ButtonsCreation(){
        button0 = new JButton("0");
        button0.setBounds(10,435,60,60);
        buttonDot = new JButton(".");
        buttonDot.setBounds(80,435,60,60);
        buttonEqual = new JButton("=");
        buttonEqual.setBounds(150,435,60,60);
        buttonPlus = new JButton("+");
        buttonPlus.setBounds(220,435,60,60);
        button1 = new JButton("1");
        button1.setBounds(10,365,60,60);
        button2 = new JButton("2");
        button2.setBounds(80,365,60,60);
        button3 = new JButton("3");
        button3.setBounds(150,365,60,60);
        buttonMinus = new JButton("-");
        buttonMinus.setBounds(220,365,60,60);
        button4 = new JButton("4");
        button4.setBounds(10,295,60,60);
        button5 = new JButton("5");
        button5.setBounds(80,295,60,60);
        button6 = new JButton("6");
        button6.setBounds(150,295,60,60);
        buttonMul = new JButton("*");
        buttonMul.setBounds(220,295,60,60);
        button7 = new JButton("7");
        button7.setBounds(10,225,60,60);
        button8 = new JButton("8");
        button8.setBounds(80,225,60,60);
        button9 = new JButton("9");
        button9.setBounds(150,225,60,60);
        buttonDiv = new JButton("/");
        buttonDiv.setBounds(220,225,60,60);
        buttonFact = new JButton("!");
        buttonFact.setBounds(10,155,60,60);
        buttonRoot = new JButton("√");
        buttonRoot.setBounds(80,155,60,60);
        buttonPower = new JButton("(²)");
        buttonPower.setBounds(150,155,60,60);
        buttonMod = new JButton("%");
        buttonMod.setBounds(220,155,60,60);
        buttonABS = new JButton("ABS");
        buttonABS.setBounds(10,85,60,60);
        buttonNEG = new JButton("NEG");
        buttonNEG.setBounds(80,85,60,60);
        buttonDEL = new JButton("DEL");
        buttonDEL.setBounds(150,85,60,60);
        buttonAC = new JButton("AC");
        buttonAC.setBounds(220,85,60,60);
    }

    public void ElementsCreation(){
        frame.add(button0);
        frame.add(buttonDot);
        frame.add(buttonEqual);
        frame.add(buttonPlus);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(buttonMinus);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(buttonMul);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(buttonDiv);
        frame.add(buttonFact);
        frame.add(buttonRoot);
        frame.add(buttonPower);
        frame.add(buttonMod);
        frame.add(buttonABS);
        frame.add(buttonNEG);
        frame.add(buttonDEL);
        frame.add(buttonAC);

        frame.add(label);
    }

    public void SetButtonsActions(){
        button0.addActionListener((e)->Display(button0));
        button1.addActionListener((e)->Display(button1));
        button2.addActionListener((e)->Display(button2));
        button3.addActionListener((e)->Display(button3));
        button4.addActionListener((e)->Display(button4));
        button5.addActionListener((e)->Display(button5));
        button6.addActionListener((e)->Display(button6));
        button7.addActionListener((e)->Display(button7));
        button8.addActionListener((e)->Display(button8));
        button9.addActionListener((e)->Display(button9));
        buttonDot.addActionListener((e)->Dot());
        buttonPlus.addActionListener((e)->Operator(buttonPlus));
        buttonMinus.addActionListener((e)->Operator(buttonMinus));
        buttonMul.addActionListener((e)->Operator(buttonMul));
        buttonDiv.addActionListener((e)->Operator(buttonDiv));
        buttonMod.addActionListener((e)->Operator(buttonMod));
        buttonEqual.addActionListener((e)->Equal());
        buttonFact.addActionListener((e)->Factorial());
        buttonRoot.addActionListener((e)->Root());
        buttonPower.addActionListener((e)->Power());
        buttonABS.addActionListener((e)->ABS());
        buttonNEG.addActionListener((e)->NegativeValue());
        buttonDEL.addActionListener((e)->DELETE());
        buttonAC.addActionListener((e)->AC());

    }

    //Update the Calculate result
    public void SetBarResult(String str)
    {
        label.setText(str);
    }

    //Check if the board is clear
    public boolean BoardIsClear() {
        if (label.getText().toString().equals(""))
            return true;
        return false;
    }

    //Check if there is Error on the calculator
    public boolean CheckIfERROR(){
        String StringBarResult = label.getText().toString();
        if(StringBarResult.equals("ERROR!"))
        {
            return true;
        }
        return false;
    }

    public void Display(JButton b) {
//        TextView Bar = ((TextView) findViewById(R.id.result));
        String BarString = label.getText().toString();
        if(BarString.equals("ERROR!"))
            return;
        if(!BarString.equals("")&&(BarString.charAt(BarString.length() - 1) == '.'))
        {
            StringBuilder sb = new StringBuilder(BarString);
            sb.append(b.getText());
            SetBarResult(sb.toString());
            return;
        }
        if (BoardIsClear()) {
            SetBarResult(b.getText().toString());
        } else {
            if(!GetNumber)
            {
                StringBuilder sb = new StringBuilder(BarString);
                sb.append(b.getText());
                SetBarResult(sb.toString());
            }
            else{
                SetBarResult(b.getText().toString());
                GetNumber = false;
            }
        }
    }

    //Place decimal point
    public void Dot() {
        if(CheckIfERROR())
        {
            return;
        }

        String StringBarResult = label.getText().toString();
        if(GetNumber==true)
        {
            SetBarResult("0.");
            return;
        }
        if(!StringBarResult.equals("")&&StringBarResult.charAt(StringBarResult.length()-1) == '.')
            return;
        if (!StringBarResult.equals("")) {
            double BarResult = Double.parseDouble(StringBarResult);
            if (BarResult - (int) BarResult != 0.0) {
                SetBarResult("ERROR!");
                return;
            }
            StringBuilder sb = new StringBuilder(StringBarResult);
            sb.append(".");
            SetBarResult(sb.toString());
        }
        else{
            SetBarResult("0.");
        }
    }

    //Takes the operator for the next calculation
    public void Operator(JButton b) {
        String BarString = label.getText().toString();
        CurrentAction = b.getText().toString();
        if (!BarString.equals(""))
            Prev = BarString;
        GetNumber = true;
    }

    //Display the result using the operator
    public void Equal() {
        if(Prev.equals("ERROR!"))
        {
            SetBarResult("ERROR!");
            return;
        }
        String BarString = label.getText().toString();
        BigDecimal BigPrev = BigDecimal.valueOf(Double.parseDouble(Prev));
        double d = 0.0;
        d = Double.parseDouble(BarString);
        BigDecimal BigBarResult = BigDecimal.valueOf(d);
        BigDecimal FinalResult = null;
        double tmp = 0.0;
        switch (CurrentAction) {
            case "+":
                FinalResult = BigPrev.add(BigBarResult);
                tmp = FinalResult.doubleValue();
                if(tmp - (int)tmp == 0.0)
                    SetBarResult(String.valueOf((int)tmp));
                else
                    SetBarResult(FinalResult.toString());
                break;
            case "-":
                FinalResult = BigPrev.subtract(BigBarResult);
                tmp = FinalResult.doubleValue();
                if(tmp - (int)tmp == 0.0)
                    SetBarResult(String.valueOf((int)tmp));
                else
                    SetBarResult(FinalResult.toString());
                break;
            case "/":
                if(BigBarResult.compareTo(BigDecimal.ZERO)==0 || BigPrev.compareTo(BigDecimal.ZERO) ==0)
                {
                    SetBarResult("ERROR!");
                    break;
                }
                FinalResult = BigPrev.divide(BigBarResult, MathContext.DECIMAL64);
                tmp = FinalResult.doubleValue();
                if(tmp - (int)tmp == 0.0)
                    SetBarResult(String.valueOf((int)tmp));
                else
                    SetBarResult(FinalResult.toString());
                break;
            case "*":
                FinalResult = BigPrev.multiply(BigBarResult);
                tmp = FinalResult.doubleValue();
                if(tmp - (int)tmp == 0.0)
                    SetBarResult(String.valueOf((int)tmp));
                else
                    SetBarResult(FinalResult.toString());
                break;
            case "%":
                double other = Double.parseDouble(BarString);
                double otherPrev = Double.parseDouble(Prev);
                if(other - (int)other != 0.0 || otherPrev - (int)otherPrev != 0.0 || other < 0)
                {
                    SetBarResult("ERROR!");
                    return;
                }
                else
                    SetBarResult(String.valueOf((int)otherPrev % (int)other));
                break;
        }
        CurrentAction = "";
    }

    //Calculate the factorial the display it
    public void Factorial()
    {
        if(CheckIfERROR())
        {
            return;
        }
        String StringBarResult = label.getText().toString();
        double tmp = Double.parseDouble(label.getText().toString());
        if(tmp - (int)tmp != 0.0 || tmp <0)
        {
            SetBarResult("ERROR!");
            return;
        }
        int result = Integer.parseInt(StringBarResult);
        if(result == 0)
        {
            SetBarResult("1");
            return;
        }
        int sum = 1;
        for(int i=1;i<=result;i++)
        {
            sum *= i;
        }
        SetBarResult(String.valueOf(sum));
    }

    //Calculate the root the display it
    public void Root()
    {
        if(CheckIfERROR())
        {
            return;
        }
        String StringBarResult = label.getText().toString();
        double tmp = Double.parseDouble(StringBarResult);
        if(tmp<0)
        {
            SetBarResult("ERROR!");
            return;
        }
        tmp = Math.sqrt(tmp);
        if(tmp - (int)tmp == 0.0)
            SetBarResult(String.valueOf((int)tmp));
        else
            SetBarResult(String.valueOf(tmp));
    }

    //Calculate the power of 2 the display it
    public void Power()
    {
        if(CheckIfERROR())
        {
            return;
        }
        String StringBarResult = label.getText().toString();
        double tmp = Double.parseDouble(StringBarResult);
        BigDecimal b = BigDecimal.valueOf(tmp);
        b = b.multiply(b);
        tmp = b.doubleValue();
        if(tmp - (int)tmp == 0.0)
            SetBarResult(String.valueOf((int)tmp));
        else
            SetBarResult(String.valueOf(tmp));
    }

    //Display the absolute value of the calculator
    public void ABS(){
        if(CheckIfERROR())
        {
            return;
        }
        String BarString = label.getText().toString();
        if(BarString.equals("-"))
        {
            SetBarResult("ERROR!");
            return;
        }
        double BarDouble = Double.parseDouble(label.getText().toString());
        if(BarDouble <0) {
            BarDouble *= -1;
            if(BarDouble - (int)BarDouble == 0.0)
                SetBarResult(String.valueOf((int)BarDouble));
            else
                SetBarResult(String.valueOf(BarDouble));
        }
    }

    //Place a negative symbol
    public void NegativeValue(){
        if(CheckIfERROR())
        {
            return;
        }
        String BarString = label.getText().toString();
        if(BarString.equals("") || GetNumber == true){
            SetBarResult("-");
            GetNumber = false;
            return;
        }
    }

    //Delete the last digit on the board
    public void DELETE(){
        String BarString = label.getText().toString();
        if(BarString.equals("ERROR!"))
            return;
        if(BarString.length()==1)
        {
            SetBarResult("");
            return;
        }
        if(BarString.length()==0)
        {
            SetBarResult("ERROR!");
            return;
        }
        BarString = BarString.substring(0,BarString.length()-1);
        SetBarResult(BarString);
    }

    //Reset the board result
    public void AC(){
        SetBarResult("");
        GetNumber = false;
    }
}
