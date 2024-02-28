package LinkedIn;

import LinkedIn.Entities.Account;
import LinkedIn.Entities.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedIn {
//    Boolean signIn(String username,String password){
//        return true;
//    }

    Map<String, Account> accounts;
    Map<String, List<Post>> posts;

    public LinkedIn(){
        accounts=new HashMap<>();
        posts=new HashMap<>();
    }

    boolean createAccount(){
        return true;
    }

    boolean createPost(){
        return true;
    }

    boolean updatePost(){
        return true;
    }

    List<Post> viewFeed(String accountId){
        //get list of following from accounts following list and fetch posts based lastupdated date
        return posts.get(accountId);
    }

}
