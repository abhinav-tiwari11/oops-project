package models;


public class User {
    private String userId;
    private String name;
    
    public User(String userId , String name)
    {
    	this.userId=userId;
    	this.name= name;
    	
    }

    void setId(String userId) {
        this.userId = userId;
    }

    void setname(String name) {
        this.name = name;
    }

    String getId() {
        return this.userId;
    }

    String getname() {
        return this.name;
    }
}