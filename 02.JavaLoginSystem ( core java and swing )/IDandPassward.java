package JavaLoginSystem;

import java.util.HashMap;

public class IDandPassward {
    HashMap<String,String> logininfo =new HashMap <String,String>();
    IDandPassward(){
        logininfo.put("Bro","pizza");
        logininfo.put("Brometheus","PASSWORD");
        logininfo.put("BroCode","abc123");
    }
 protected HashMap getLoginInfo(){
        return logininfo;
    }
}
