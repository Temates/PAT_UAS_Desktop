package Login_Page;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) throws Exception {

        new LoginPage();
        //new Data_GET();
//    SwingUtilities.invokeLater(new Runnable(){
//    public void run() {
//
//        String test1 = "{\"id_akun\": \"1\" , \"username\" : \"Nando\",\"email\" : \"test@gmail.com\", \"section\" : \"Chief\", \"date_Creation\":\"2020-05-7,00:20:56\"}";
////        String jsonUser1 = "{ \"firstName\": \"Stack\", \"lastName\": \"Overflow\"}";
////        String jsonUser2 = "{ \"firstName\": \"Pee\", \"lastName\": \"Skillet\"}";
//        ObjectMapper mapper = new ObjectMapper();
//        DataModel user1 = null;
//        DataModel user2 = null;
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//        DataModel test = null;
//        try {
//            user1 = mapper.readValue(jsonUser1, DataModel.class);
//            user2 = mapper.readValue(jsonUser2, DataModel.class);
//            test = mapper.readValue(test1,DataModel.class);
//        } catch (JsonMappingException e) {
//            throw new RuntimeException(e);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        List<DataModel> users = new ArrayList<DataModel>();
//        //users.add(user1);
        //users.add(user2);
//        users.add(test);
//        System.out.println(test);
//        Tabel_Model model = new Tabel_Model(users);
//        JTable table = new JTable(model) {
//            @Override
//            public Dimension getPreferredScrollableViewportSize() {
//                return new Dimension(800, 600);
//            }
//        };
//        JOptionPane.showMessageDialog(null, new JScrollPane(table));
//    }
//    });
    }

}
