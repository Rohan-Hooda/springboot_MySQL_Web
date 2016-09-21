package com.example.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String ItemID;
    public String Quantity;

    public Post(){
    }

    public Post(String Quantity){
        this.Quantity = Quantity;
    }

    public String getId() {
        return getItemID();
    }

    public String getMessage() {
        return Quantity;
    }

    public void setMessage(String Quantity) {
        this.Quantity = Quantity;
    }

	public String getItemID() {
		return ItemID;
	}

	public void setItemID(String itemID) {
		this.ItemID = itemID;
	}
    
}