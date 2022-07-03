package Login_Page;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Data_GET extends JFrame{
    private JPanel panel1;
    private JLabel LUsername;
    private JLabel LEmail;
    private JTextField Username;
    private JTextField Email;
    private JTextField Section;
    private JButton Savebutton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField search;
    private JLabel LSearch;
    private JLabel LSection;
    private JButton attendanceDataButton;
    private JButton salaryDataButton;
    private JTextField textField1;
    private JTable table1;
    private JButton searchButton;
    private JFrame frame;

    public Data_GET() throws Exception {
        frame = new JFrame("Employe Data Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setResizable(true);

        //now add the panel
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        getREST();


        Savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    postREST();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchRest();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void searchRest() throws IOException {

        String url = "http://192.168.0.9:3000/insert_akun";

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
        jsonParam.put("id_akun", search.getText());
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
        JOptionPane.showMessageDialog(null,response);
        System.out.println("Data : \n" +response.toString());
        JSONArray myArray = new JSONArray(response.toString());
        //for (int i=0; i < myArray.length();i++){
            JSONObject arrObj = myArray.getJSONObject(0);
            System.out.println("Data Title : ");
            System.out.println(arrObj);
        int id_akun;
        String username = null;
        String email = null;
        String section = null;
        String date_creation = null;
            if(arrObj.toString().trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan!");
            }else{

                username = arrObj.getString("Username");
                email = arrObj.getString("Email");
                section = arrObj.get("Section").toString();
                date_creation = arrObj.getString("Date_Creation");

            }
            Username.setText(username);
            Email.setText(email);
            Section.setText(section);
            JOptionPane.showMessageDialog(null,arrObj);
        //}
        os.flush();
        os.close();
    }

    public void postREST() throws Exception {

        String url = "http://192.168.0.9:3000/insert_akun";

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
        jsonParam.put("Username", Username.getText());
        jsonParam.put("Email", Email.getText());
        if(Section.getText().trim().isEmpty()){

        }else{
            jsonParam.put("Section", Section.getText());
        }

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
        JOptionPane.showMessageDialog(null,response);
        System.out.println("Data : \n" +response.toString());
//        JSONArray myArray = new JSONArray(response.toString());
//        for (int i=0; i < myArray.length();i++){
//            JSONObject arrObj = myArray.getJSONObject(i);
//            System.out.println("Data Title : ");
//            System.out.println(arrObj);
//            JOptionPane.showMessageDialog(null,arrObj);
//        }
        os.flush();
        os.close();

    }
    public void getREST() throws Exception{
        String url = "http://192.168.0.9:3000/Table";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
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
        System.out.println("Data : \n" +response);



        //.showMessageDialog(null, new JScrollPane(table));
        JSONArray myArray = new JSONArray(response.toString());
        List<DataModel> users = new ArrayList<DataModel>();

        DataModel test = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        for (int i=0; i < myArray.length();i++){
            JSONObject arrObj = myArray.getJSONObject(i);
            int id_akun = arrObj.getInt("id_akun");
            String username = arrObj.getString("Username");
            String email = arrObj.getString("Email");
            String section = arrObj.get("Section").toString();
            String date_creation = arrObj.getString("Date_Creation");
            try {
                String test1 = "{\"id_akun\": \""+id_akun+"\" , \"username\" : \""+username+"\",\"email\" : \""+email+"\", \"section\" : \""+section+"\", \"Date_Creation\":\""+date_creation+"\"}";

                //String test1 = "{\"id_akun\": \""+id_akun+"\"}";
                test = mapper.readValue(test1,DataModel.class);
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            users.add(test);
        }


        Tabel_Model model = new Tabel_Model(users);
        table1.setModel(model);



    }



}
