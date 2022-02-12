import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GraphicsHandler extends Application {
   
    Stage window;
    Scene loginScene;
    Scene signupScene;
    Scene chatScene;
    Scene userProfileScene;
    String userName;
    String password;
    public static String setUserName;
    boolean getUserName;
    boolean DARKMODE=true;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        
        

        window=primaryStage;
        window.setTitle("User Login");

        GridPane grid=new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(20);
        grid.setHgap(20);
        GridPane.setConstraints(grid, 0, 0);
        
        //This is for the login page
        Label loginLabel=new Label("User Login");
        loginLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        loginLabel.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(loginLabel, 2, 1);

        
        Label nameLabel=new Label("UserName");
        nameLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        nameLabel.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(nameLabel, 1, 7);
        
        
        TextField nameInput=new TextField();
        GridPane.setConstraints(nameInput, 2, 7);
        nameInput.setPromptText("Username");
        
        Label passLabel=new Label("Password");
        passLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        passLabel.setTextFill(Color.web("#A9A9A9"));
        
        GridPane.setConstraints(passLabel, 1, 9);
        
        PasswordField passInput=new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 2, 9);
        
        Label notUserLabel=new Label("New User? ");
        notUserLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        notUserLabel.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(notUserLabel, 2, 13);
        
        Button signup=new Button("Sign up");
        signup.setStyle("-fx-base: green;");
        Button login=new Button("Login");
        login.setStyle("-fx-base: green;");
        GridPane.setConstraints(signup, 3, 13);
        GridPane.setConstraints(login, 2, 11);
        
        //This is for the sign up page
        GridPane grid2=new GridPane();
        grid2.setPadding(new Insets(20,20,20,20));
        //this is for setting the vertical gap and horizontal gap between the components
        grid2.setVgap(20);
        grid2.setHgap(20);
        
        Label signupLabel=new Label("Signup Page");
        signupLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        signupLabel.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(signupLabel, 2, 1);
        
        Label nameLabel2=new Label("UserName");
        nameLabel2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        nameLabel2.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(nameLabel2, 1, 7);
        GridPane.setConstraints(grid2, 10, 10);
        TextField nameInput2=new TextField();
        GridPane.setConstraints(nameInput2, 2, 7);
        nameInput2.setPromptText("Username");
        Label passLabel2=new Label("Password");
        passLabel2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        passLabel2.setTextFill(Color.web("#A9A9A9"));

        GridPane.setConstraints(passLabel2, 1, 9);
        PasswordField passInput2=new PasswordField();
        passInput2.setPromptText("Password");
        GridPane.setConstraints(passInput2, 2, 9);

        Label signedUp2=new Label("Already SignedUp?");
        signedUp2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        signedUp2.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(signedUp2, 2, 13);
        Button signIn2=new Button("Sign in");
        signIn2.setStyle("-fx-base: green;");
        GridPane.setConstraints(signIn2, 3, 13);
        Button signUp2=new Button("Sign Up");
        signUp2.setStyle("-fx-base: green;");
        GridPane.setConstraints(signUp2, 2, 11);


        //This is for the chat page
        GridPane grid3=new GridPane();
        grid3.setPadding(new Insets(20,20,20,20));
        grid3.setVgap(20);
        grid3.setHgap(20);
        TextArea messageStorage=new TextArea();
        messageStorage.setPrefColumnCount(25);
        messageStorage.setPrefRowCount(20);
        GridPane.setConstraints(messageStorage, 0, 2);
        TextField sendMsg = new TextField();
        GridPane.setConstraints(sendMsg, 0, 3);
        Button send = new Button("Send");
        send.setStyle("-fx-base: green;");
        GridPane.setConstraints(send,1, 3);
        Button logout = new Button("Log out");
        logout.setStyle("-fx-base: green;");
        logout.setAlignment(Pos.CENTER);
        GridPane.setConstraints(logout,2, 4);
                
        Label chat = new Label("Chat");
        chat.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        chat.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(chat, 0, 1);
        
        Label activeUsersList = new Label("Active Users");
        activeUsersList.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        activeUsersList.setTextFill(Color.web("#A9A9A9"));
        GridPane.setConstraints(activeUsersList, 2, 1);
        
        Label userProfileName = new Label(setUserName+" User Profile");
        userProfileName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        userProfileName.setTextFill(Color.web("#A9A9A9"));
        userProfileName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setConstraints(userProfileName, 2, 0);
        
        Button mode = new Button("Select Mode");
        mode.setStyle("-fx-base: green;");
        GridPane.setConstraints(mode, 0, 5);
        
        ChoiceBox<String> modeChoiceBox=new ChoiceBox(); 
        modeChoiceBox.getItems().addAll("Dark Mode","Light Mode");
        modeChoiceBox.setValue("Dark Mode");
        GridPane.setConstraints(modeChoiceBox, 0, 6); 
         
         
         Label wrongLogin = new Label("Invalid username or password");
         wrongLogin.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        wrongLogin.setTextFill(Color.web("#A9A9A9"));
         GridPane.setConstraints(wrongLogin, 2, 12);
         
         Label wrongName = new Label("Username already exixts.");
         wrongName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        wrongName.setTextFill(Color.web("#A9A9A9"));
         GridPane.setConstraints(wrongName, 2, 12);
         
         
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
        list.add("Mehreen");//Adding object in arraylist    
        list.add("Fabliha");    
        list.add("Himika");    
        list.add("Jackie Chan");    
        //Invoking arraylist object   
        System.out.println(list);  
        
        ListView<String> listview=new ListView<>();
        listview.getItems().addAll(list);
        listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        GridPane.setConstraints(listview, 2, 2);
        File file;
        file = new File("C:/Users/ASUS/Documents/NetBeansProjects/GraphicsHandler/src/loginBackground2.bmp");
        FileInputStream input=new FileInputStream(file);
        Image image=new Image(input,800,800,false,false);
        BackgroundImage imageBackground=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background background =new Background(imageBackground);

        grid.setBackground(background);
        grid2.setBackground(background);
        grid3.setBackground(background);


        grid.getChildren().addAll(loginLabel,nameLabel,nameInput,passLabel,passInput,signup,login,notUserLabel);
        grid2.getChildren().addAll(signupLabel,nameLabel2,nameInput2,passLabel2,passInput2,signedUp2,signIn2,signUp2);
        grid3.getChildren().addAll(messageStorage,sendMsg,send,chat,logout,userProfileName,mode,modeChoiceBox,activeUsersList,listview);

        window.getIcons().add(new Image("file:C:/Users/ASUS/Documents/NetBeansProjects/GraphicsHandler/src/chatBox.bmp"));
        loginScene=new Scene(grid,800,800);
        signupScene=new Scene(grid2,800,800);
        chatScene = new Scene(grid3,800,800);

        window.setScene(loginScene);
        window.show();
         
         signup.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                window.setScene(signupScene);
            }
            });
        signIn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               window.setScene(loginScene);
            }
        });
        signUp2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                boolean valid = false;
                String userName2=nameInput2.getText();
                setUserName=setUserName+userName2;
                String password2=passInput2.getText();
                System.out.println(userName2);
                
                System.out.println(password2);
                User signUp = new User("signup",userName2,password2);
                try {
                    valid = signUp.enter();
                } catch (IOException ex) {
                    Logger.getLogger(GraphicsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(valid){
                    window.setScene(chatScene);
                    getUserName=true;
                }
                else{
                     grid2.getChildren().addAll(wrongName);
                     passInput2.clear();
                 }
            }

            
        });
        
        login.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                boolean valid=false;
                String userName=nameInput.getText();
                String password=passInput.getText();
                setUserName=setUserName+userName;
                System.out.println(userName);
                System.out.println(password);

                User signIn = new User("signin",userName,password);
                try {
                       valid = signIn.enter();
                       } catch (IOException ex) {
                           Logger.getLogger(GraphicsHandler.class.getName()).log(Level.SEVERE, null, ex);}
                if(valid){
                    window.setScene(chatScene);
                    getUserName=true;
                }
                else{
                    grid.getChildren().addAll(wrongLogin);
                    passInput.clear();
                }
                
            }

            
       });
        
    logout.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            window.setScene(loginScene);
            nameInput.clear();
            passInput.clear();
            //socket.close();
        }
        });
    mode.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               String str= getChoice(modeChoiceBox);
                
               if(str.equals("Dark Mode")){
                   File file;
                    file = new File("C:/Users/ASUS/Documents/NetBeansProjects/GraphicsHandler/src/loginBackground2.bmp");
                    FileInputStream input = null;
                   try {
                       input = new FileInputStream(file);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(GraphicsHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    Image image=new Image(input,800,800,false,false);
                    BackgroundImage imageBackground=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                    Background background =new Background(imageBackground);
                    
                 
                    grid.setBackground(background);
                    grid2.setBackground(background);
                    grid3.setBackground(background);
               
               }
                   
               else{
                   
               File file = new File("C:/Users/ASUS/Documents/NetBeansProjects/GraphicsHandler/src/loginBackground3.bmp");
               FileInputStream input = null;
                   try {
                       input = new FileInputStream(file);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(GraphicsHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
                Image image=new Image(input,800,800,false,false);
                BackgroundImage imageBackground=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
                Background background =new Background(imageBackground);

                grid.setBackground(background);
                grid2.setBackground(background);
                grid3.setBackground(background);
               }
            }


            });
    }
    public TreeItem<String>makeBranch(String title, TreeItem<String> parent){
       TreeItem<String> item=new TreeItem<String>(title);
       item.setExpanded(true);
       parent.getChildren().add(item);
       return item;
     }
    public static void main(String[] args) {
        launch(args);
    }
    public String getChoice(ChoiceBox<String> modeChoiceBox) {
        String modeType=" ";
        modeType = modeChoiceBox.getValue();
        
        System.out.println(modeType);
        return modeType;
    }
    
    
}