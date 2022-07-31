package JavaLoginSystem;
public class JavaLoginSystemMain {

    public static void main(String[] args) {
        IDandPassward idandPasswaeds = new IDandPassward();
        
        LoginPage loginpage = new LoginPage(idandPasswaeds.getLoginInfo() );
        
    }
    
}
