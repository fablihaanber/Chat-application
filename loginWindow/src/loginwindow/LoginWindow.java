/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwindow;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.lang.Object;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 *
 * @author Fabliha
 */
public class LoginWindow extends Application {
   
    Stage window;
    Scene loginScene;
    Scene signupScene;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        String userName=null;
        String password=null;
        
        window=primaryStage;
        window.setTitle("User Login");
        
        GridPane grid=new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(10);
        
       // NAme Label
       Label nameLabel=new Label("UserName");
     //  nameLabel.setFont(Font.font ("Verdana", 20));
       nameLabel.setTextFill(Color.web("#E8E8E8"));
       GridPane.setConstraints(nameLabel, 0, 2);
       GridPane.setConstraints(grid, 0, 0);
       
       //Name Input
       Label loginLabel=new Label("Login");
       loginLabel.setTextFill(Color.web("#E8E8E8"));
       loginLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       GridPane.setConstraints(loginLabel, 1, 0);
       TextField nameInput=new TextField();
       userName=nameInput.getText();
       GridPane.setConstraints(nameInput, 1, 2);
       nameInput.setPromptText("Username");
       
       Label passLabel=new Label("Password");
       passLabel.setTextFill(Color.web("#E8E8E8"));
       GridPane.setConstraints(passLabel, 0, 3);
       PasswordField passInput=new PasswordField();
       password=passInput.getText();
       //passInput.setDisable(true);
       passInput.setPromptText("Password");
       GridPane.setConstraints(passInput, 1, 3);
       Label notUserLabel=new Label("New User? ");
       notUserLabel.setTextFill(Color.web("#E8E8E8"));
       GridPane.setConstraints(notUserLabel, 1, 5);
       Label UnsuccessfulLogin = new Label();
       Button newlogin=new Button("Sign up");
       Button login=new Button("Login");
       GridPane.setConstraints(newlogin, 2, 5);
       GridPane.setConstraints(login, 1, 4);
       FileInputStream input=new FileInputStream("C:/Users/ASUS/Documents/NetBeansProjects/loginWindow/src/loginwindow/loginBackground.bmp");
       Image image=new Image(input,400,400,false,false);
       BackgroundImage imageBackground=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
       Background background =new Background(imageBackground);
      // imageBackground.setImage(image);
      // BackgroundImage m=new BackgroundImage();
       newlogin.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                GridPane grid2=new GridPane();
                grid2.setPadding(new Insets(20,20,20,20));
                grid2.setVgap(10);
                grid2.setHgap(10);
                signupScene=new Scene(grid2,400,300);
                window.setScene(signupScene);
                // NAme Label
                Label nameLabel2=new Label("UserName");
                GridPane.setConstraints(grid2, 10, 10);
                //Name Input
                TextField nameInput2=new TextField();
                GridPane.setConstraints(nameInput2, 1, 0);
                nameInput.setPromptText("Username");
                Label passLabel2=new Label("Password");
                GridPane.setConstraints(passLabel2, 0, 1);
                PasswordField passInput2=new PasswordField();
                passInput2.setPromptText("Password");
                GridPane.setConstraints(passInput2, 1, 1);
                Label signedUp2=new Label("Already SignedUp?");
                
                GridPane.setConstraints(signedUp2, 1, 4);
                Button signIn2=new Button("Sign in");
                GridPane.setConstraints(signIn2, 2, 4);
                Button signUp2=new Button("Sign Up");
                GridPane.setConstraints(signUp2, 1, 3);
                grid2.getChildren().addAll(nameLabel2,nameInput2,passLabel2,passInput2,signedUp2,signIn2,signUp2);
                signIn2.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                       window.setScene(loginScene);
                    }
                });
                signUp2.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        String userName2=nameInput2.getText();
                        String password2=passInput2.getText();
                        System.out.println(password2);
                        System.out.println(userName2);
                        Client a = new Client(1,userName2,password2);
                        try {
                            a.execute();
                            /*try {
                            fileSignUp(userName2,password2);
                            } catch (IOException ex) {
                            System.out.println(ex);
                            }*/
                        } catch (IOException ex) {
                            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
            }

            
       });
       login.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                boolean loginSuccessful=false;
               String userName=nameInput.getText();
               String password=passInput.getText();
                System.out.println(password);
                 System.out.println(userName);
                 Client b = new Client(2,userName,password);
                try {
                    b.execute();
                    
                    
                    /*try {
                    loginSuccessful=fileSignIn(userName,password);
                    } catch (IOException ex) {
                    System.out.println(ex);
                    }*/
                    if(loginSuccessful){
                    GridPane gridUserProfile=new GridPane();
                    gridUserProfile.setPadding(new Insets(20,20,20,20));
                    gridUserProfile.setVgap(10);
                    gridUserProfile.setHgap(10);
                    
                    signupScene=new Scene(gridUserProfile,400,300);
                    window.setScene(signupScene);
                    ChoiceBox<String> choiceBox=new ChoiceBox(); 
                    choiceBox.getItems().addAll("apples","Banana","Mango","Litchi");
                    
                    
                    }
                    else {
                    UnsuccessfulLogin.setText("Invalid username or password");
                    GridPane.setConstraints(UnsuccessfulLogin, 1, 5);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            
       });
       //FileInputstream input=new FileInputstream("C:\Users\ASUS\Documents\NetBeansProjects\loginWindow\src\loginwindow\black-and-green-wallpaper-hd-28.jpg");
      grid.setBackground(background);
       grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,newlogin,login,notUserLabel,UnsuccessfulLogin,loginLabel);
      loginScene=new Scene(grid,500,500);
      
     
      
      
       window.setScene(loginScene);
      
      // window.setResizable(false);
       window.getIcons().add(new Image("file:C:/Users/ASUS/Documents/NetBeansProjects/loginWindow/src/loginwindow/black-and-green-wallpaper-hd-28.jpg"));
       window.show();
    }
/*private void fileSignUp(String userName, String password) throws FileNotFoundException, IOException {
                
               
                String newLine="\n";
                String space=" ";
                boolean f=false;
                
             try (Scanner scanner = new Scanner(new File("C:/Users/ASUS/Documents/NetBeansProjects/Tutorial5/src/tutorial5/file1.txt"))) {
          
        try{
            while(scanner.hasNextLine()){
                String scanner1=scanner.next();
                String scanner2=scanner.next();
                if(scanner1.equals(userName) && scanner2.equals(password)){
                   f=true; 
                   break;
                }
            }
               if(f)System.out.println("Choose a different email ID");
            }catch(Exception e){
               f=false;
            }
          //  System.out.println(scanner.next());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }      
            if(f==false){
            File file=new File("C:/Users/ASUS/Documents/NetBeansProjects/Tutorial5/src/tutorial5/file1.txt");
            StringBuilder sb=new StringBuilder();
            sb.append("\n"+userName+" "+password+"\n");
            FileWriter w=new FileWriter(file,true);
            w.write(sb.toString());
            w.close();
            }
            
        
        
        
            }
public boolean fileSignIn(String userName, String password) throws FileNotFoundException, IOException {
                
               
            String newLine="\n";
            String space=" ";
             boolean flag=false; 
            //File file=new File("C:/Users/ASUS/Documents/NetBeansProjects/Tutorial5/src/tutorial5/file1.txt");
            try (Scanner scanner = new Scanner(new File("C:/Users/ASUS/Documents/NetBeansProjects/Tutorial5/src/tutorial5/file1.txt"))) {
          
            try{
                while(scanner.hasNextLine()){
                    String scanner1=scanner.next();
                    String scanner2=scanner.next();
                    if(scanner1.equals(userName) && scanner2.equals(password)){
                       flag=true; 
                       break;
                    }
                }
                   if(flag)System.out.println("Sign in successful.");
                }catch(Exception e){
                    System.out.println("Invalid Username or Password.");
                }
          //  System.out.println(scanner.next());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
            return flag;
 }

            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
