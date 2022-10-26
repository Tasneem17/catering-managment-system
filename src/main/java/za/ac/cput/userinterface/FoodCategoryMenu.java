package za.ac.cput.userinterface;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;
import za.ac.cput.entity.Category;
import za.ac.cput.entity.Food;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.factory.FoodFactory;
import za.ac.cput.factory.MenuFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

public class FoodCategoryMenu extends JFrame {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

     private  static  final    Gson gson = new Gson();
    private  static final OkHttpClient client = new OkHttpClient();
    private JPanel MainPanel;
    private JTextField CatIdtxt;
    private JTextField CatNametxt;
    private JTextField CatDesctxt;
    private JButton CatSavebtn;
    private JButton Catreadbtn;
    private JButton Catdelbtn;
    private JButton prevbtn;
    private JButton nextbtn;
    private JLabel MenuId;
    private JLabel MenuItems;
    private JLabel MenuPrice;
    private JTextField menuIdtxt;
    private JTextField menuItemstxt;
    private JTextField menuPricetxt;
    private JTextField foodIdtxt;
    private JTextField foodNametxt;
    private JTextField fooddesctxt;
    private JTextField foodquatxt;
    private JTextField foodpricetxt;
    private JButton menuSavebtn;
    private JButton foodSavebtn;
    private JButton menuReadbtn;
    private JButton foodReadbtn;
    private JButton foodDelbtn;
    private JButton menuDelbtn;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JButton foodClearbtn;
    private JButton menuClearbtn;
    private JButton catClearbtn;

    public  String post(final  String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url).addHeader("Authorization",Credentials.basic("userA","12345"))
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.printf(request.toString());
            System.out.printf(response.message());
            JOptionPane.showMessageDialog(null,response);
            return response.body().string();
        }
    }
    private static String del(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url).addHeader("Authorization",Credentials.basic("userA","12345"))
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }
    private static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url).addHeader("Authorization",Credentials.basic("userA","12345"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }
    public void Catsave(String category_ID, String category_Name, String category_Description) {
        try {
            final String url = "http://localhost:8080/category/save";
            Category cat = CategoryFactory.createCategory(category_ID,category_Name,category_Description);
            assert cat != null;
            String JsonString = gson.toJson(cat);
            String post = post(url, JsonString);

            if (post != null)
                JOptionPane.showMessageDialog(null, "Saved successfully");
            else
                JOptionPane.showMessageDialog(null, "ERROR!! Not Saved successfully!");
        } catch (HeadlessException | IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void Foodsave(String  Food_ID,String Food_Name, String Food_Description, String Food_Quantity, double Food_Price) {
        try {
            final String url = "http://localhost:8080/food/save";
            Food food = FoodFactory.createFood(Food_ID,Food_Name,Food_Description, Food_Quantity, Food_Price);
            assert food != null;
            String JsonString = gson.toJson(food);
            String post = post(url, JsonString);

            if (post != null)
                JOptionPane.showMessageDialog(null, "Saved successfully");
            else
                JOptionPane.showMessageDialog(null, "ERROR!! Not Saved successfully!");
        } catch (HeadlessException | IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void Menusave(String Menu_ID,  String  Menu_Items, double Menu_Price) {
        try {
            final String url = "http://localhost:8080/menu/save";
            Menu menu = MenuFactory.createMenu(Menu_ID, Menu_Items, Menu_Price);
            assert menu != null;
            String JsonString = gson.toJson(menu);
            String post = post(url, JsonString);

            if (post != null)
                JOptionPane.showMessageDialog(null, "Saved successfully");
            else
                JOptionPane.showMessageDialog(null, "ERROR!! Not Saved successfully!");
        } catch (HeadlessException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
//GetBy Id response
    private void CatgereadId() {
        try {
            final String url = "http://localhost:8080/category/read/"+CatIdtxt.getText();
            String responseBody = get(url);
            JSONObject catArray = new JSONObject(responseBody);

            for (int i = 0; i < catArray.length(); i++) {
                Gson gson = new Gson();
                Category cat = gson.fromJson(String.valueOf(catArray), Category.class);
                System.out.println(catArray.toString());
                System.out.println(cat.toString());
                CatNametxt.setText(cat.getCategory_Name());
                CatDesctxt.setText(cat.getCategory_Description());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void FoodReadId() {
        try {
            final String url = "http://localhost:8080/food/read/"+foodIdtxt.getText();
            String responseBody = get(url);
            JSONObject catArray = new JSONObject(responseBody);

            for (int i = 0; i < catArray.length(); i++) {
                Gson gson = new Gson();
                Food food = gson.fromJson(String.valueOf(catArray), Food.class);
                System.out.println(catArray.toString());
                System.out.println(food.toString());
                foodNametxt.setText(food.getFood_Name());
                foodquatxt.setText(food.getFood_Quantity());
                fooddesctxt.setText(food.getFood_Description());
                foodpricetxt.setText(String.valueOf(food.getFood_Price()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void  MenuReadId(){
        try {
            final String url = "http://localhost:8080/menu/read/"+menuIdtxt.getText();
            String responseBody = get(url);
            JSONObject catArray = new JSONObject(responseBody);

            for (int i = 0; i < catArray.length(); i++) {
                Gson gson = new Gson();
                Menu menu = gson.fromJson(String.valueOf(catArray), Menu.class);
                System.out.println(catArray.toString());
                System.out.println(menu.toString());
                menuPricetxt.setText(String.valueOf(menu.getMenu_Price()));
                menuItemstxt.setText(menu.getMenu_Items());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    ////////////////////////////////////////////////////////////////////////////////
    //Delete
    private   void  Catdel() throws IOException {
        try {
            final String url ="http://localhost:8080/category/delete/"+CatIdtxt.getText();
            String responseBody = del(url);
            JOptionPane.showMessageDialog(null,responseBody);
            System.out.println(responseBody);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private   void  fooddel() throws IOException {
        try {
            final String url ="http://localhost:8080/food/delete/"+foodIdtxt.getText();
            String responseBody = del(url);
            JOptionPane.showMessageDialog(null,responseBody);
            System.out.println(responseBody);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private   void  menudel() throws IOException {
        try {
            final String url ="http://localhost:8080/menu/delete/"+menuIdtxt.getText();
            String responseBody = del(url);
            JOptionPane.showMessageDialog(null,responseBody);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void Clear_Food_Field() {
        foodIdtxt.setText("");
        fooddesctxt.setText("");
        foodNametxt.setText("");
        foodquatxt.setText("");
        foodpricetxt.setText("");

    }
    public void Clear_Category_Field() {
        CatDesctxt.setText("");
            CatIdtxt.setText("");
        CatNametxt.setText("");
    }
    public void Clear_Menu_Field() {
        menuIdtxt.setText("");
        menuItemstxt.setText("");
        menuPricetxt.setText("");
    }

    public  void Food_Empty(){
        if(foodIdtxt.getText().isEmpty()||
                fooddesctxt.getText().isEmpty()|| foodNametxt.getText().isEmpty()||
                foodquatxt.getText().isEmpty()|| foodpricetxt.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please fill all fields");
    }
    public  void Category_Empty(){
        if(CatDesctxt.getText().isEmpty()||CatIdtxt.getText().isEmpty()|| CatNametxt.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please fill all fields");
    }
    public  void Menu_Empty(){
        if(menuIdtxt.getText().isEmpty()||menuItemstxt.getText().isEmpty()|| menuPricetxt.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please fill all fields");
    }

    public FoodCategoryMenu() {
        setLayout(null);
        setTitle("FoodCategoryMenu");
        setContentPane(MainPanel);
        setSize(700, 400);
        setBounds(250,300,700,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        prevbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EquipmentUI form = new EquipmentUI();
                setVisible(false);
            }
        });
        catClearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear_Category_Field();
            }
        });
        menuClearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear_Menu_Field();
            }
        });
        foodClearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear_Food_Field();
            }
        });
        menuPricetxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                super.keyTyped(ke);
                String value = menuPricetxt.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    menuPricetxt.setEditable(true);
                } else {
                    menuPricetxt.setEditable(false);
                }
            }
        });
        foodpricetxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                super.keyTyped(ke);
                    String value = foodpricetxt.getText();
                    int l = value.length();
                    if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ) {
                        foodpricetxt.setEditable(true);
                    } else {
                        foodpricetxt.setEditable(false);
                    }
            }
        });
        CatSavebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Category_Empty();
                Catsave(CatIdtxt.getText(),CatNametxt.getText(), CatDesctxt.getText());
                System.out.println(CatIdtxt.getText()+"    "+ CatNametxt.getText()+"   "+ CatDesctxt.getText());
            }
        });
        menuSavebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_Empty();
                Menusave(menuIdtxt.getText(), menuItemstxt.getText(), Double.parseDouble(menuPricetxt.getText()));
            }
        });
        foodSavebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food_Empty();
                Foodsave(foodIdtxt.getText() ,foodNametxt.getName(),
                        fooddesctxt.getText(), foodquatxt.getText(), Double.parseDouble(foodpricetxt.getText()));

                System.out.println("Food Record{ "+"FoodId: " +foodIdtxt.getText() +"  FoodName: "+foodNametxt.getText()+
                       "Food Description: " + fooddesctxt.getText()+"   FoodQuantity"+ foodquatxt.getText()+"   Food Price"+ Double.parseDouble(foodpricetxt.getText()));
            }
        });
        Catreadbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatgereadId();
            }
        });
        foodReadbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodReadId();
            }
        });
        menuReadbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReadId();
            }
        });
        menuDelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menudel();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        foodDelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fooddel();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Catdelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Catdel();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }



    public static void main(String[] args)
    {
        FoodCategoryMenu fcm = new FoodCategoryMenu();

    }
}
