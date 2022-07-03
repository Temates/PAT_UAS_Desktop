package Login_Page;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginPage extends JFrame{
    private JTextField Username;
    private JPasswordField Password;
    private JButton loginButton;
    private JLabel username;
    private JLabel password;
    private JButton resetButton;
    private JPanel panel1;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JFrame frame;

    boolean login_condition = false;
    public LoginPage(){
        frame = new JFrame("Login Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,250));
        frame.setResizable(false);

        //now add the panel
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Username.setText("");
                Password.setText("");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Username.getText().trim().isEmpty() && Password.getText().trim().isEmpty()) {
                    lbl_username.setText("Username is Empty");
                    lbl_password.setText("Password is Empty");
                } else if (username.getText().trim().isEmpty()) {
                    lbl_username.setText("Username is Empty");
                } else if (password.getText().trim().isEmpty()) {
                    lbl_password.setText("Password is Empty");
                } else {
                    try {
                        loginREST(username.getText(), password.getText());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    public void loginREST(String username,String password) throws Exception {

        String url = "http://192.168.0.9:3000/login";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST"); //PUT / DELETE
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.connect();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("username", Username.getText());
        jsonParam.put("password", Password.getText());
        System.out.println(jsonParam.toString());//
        byte[] jsData = jsonParam.toString().getBytes("UTF-8");
        OutputStream os = con.getOutputStream();
        os.write(jsData);
        int responseCode = con.getResponseCode();
        System.out.println("Send Get Request to : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String input;
        StringBuffer response = new StringBuffer();
        while ((input=in.readLine())!=null){
            response.append(input);
        }
        in.close();

        //System.out.println("Data : \n" +response.toString());
//        JSONArray myArray = new JSONArray(response.toString());
//        for (int i=0; i < myArray.length();i++){
//            JSONObject arrObj = myArray.getJSONObject(i);
//            System.out.println("Data Title : ");
//            System.out.println(arrObj);
//            JOptionPane.showMessageDialog(null,arrObj);
//        }
        os.flush();
        os.close();
        if(response.toString().equals("Login Sukses")){
            JOptionPane.showMessageDialog(null,response);


            frame.dispose(); //Destroy the JFrame object
            JFrame nF = new Data_GET();
            nF.setSize(800,600);
            nF.setLocationRelativeTo(null);
            nF.setResizable(true);
            nF.setVisible(true); //you can't see me!
        }else if (response.toString().equals("Login Gagal")){

            JOptionPane.showMessageDialog(null,response);

        }

    }

}
