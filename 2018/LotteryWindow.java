
/*
 * This class constructs the lottery window.
 *
 * @author (Nicholas Wan)
 * @version (02/12/2018)
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LotteryWindow {

//    Data
    private ArrayList<String> names;
    private int maxNumber;

//    Gui
    private JFrame myFrame;
    private JTextField nameField;
    private JPanel namePanel;
    private JPanel buttonPanel;
    private JPanel wholePanel;
    private JButton startButton;
    private JButton stopButton;
    private JButton exitButton;


    // This is the testing main method, write the appropriate main method in a seperate file.
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> list = new ArrayList<String>();
        String eventDate = "2018-02-10  7:00 PM";
        //list.add("First"); 
        //list.add("Second");
        //list.add("Third");
        //list.add("Fourth");
        //list.add("Fifth");
        File file;
        if (0 < args.length) {
            file = new File(args[0]);
        }else{        
            String fileName = "test.csv";
            file = new File(fileName);
        }
        Scanner inputStream = new Scanner(file);
        //skip header
        inputStream.nextLine();
       
       while(inputStream.hasNextLine()){
            String data = inputStream.nextLine();
            Scanner lineScan = new Scanner(data);
            lineScan.useDelimiter(",");
            if(!lineScan.next().equals(eventDate))
                continue;
            lineScan.next();
            String lastName = lineScan.next();
            String firstName = lineScan.next();
            String fullName  = firstName +" "+ lastName;
            list.add(fullName);
            //System.out.println(fullName);
            lineScan.close();
       }
       
       inputStream.close();
       for (int i = 0; i<list.size(); i++){
            System.out.println((i+1) + list.get(i));
       }
       LotteryWindow lw = new LotteryWindow(list);
        
       return; 
    }
    public LotteryWindow(ArrayList<String> nameList){
//        Data
        names = nameList;
        maxNumber = names.size();
        Timer t = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRandomName(maxNumber);
            }
        });
        t.setRepeats(true);

//        Gui
        myFrame = new JFrame();

        namePanel = new JPanel(new BorderLayout());
        nameField = new JTextField(10);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setColumns(600);
        nameField.setFont(new Font("Goudy Old Style", Font.ITALIC, 120));
        namePanel.add(nameField, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        startButton.setSize(200,90);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });
        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        stopButton.setSize(200,90);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        exitButton.setSize(200,90);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                System.exit(0);
            }
        });
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(exitButton);

        wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));

        wholePanel.add(namePanel);
        wholePanel.add(buttonPanel);
        myFrame.add(wholePanel);
        myFrame.setSize(1200,600);
        myFrame.setVisible(true);
    }

    public void printRandomName(int maxNumer){
        int num = (int)(Math.random() * maxNumber);
        nameField.setText(names.get(num));
    }
    
}
