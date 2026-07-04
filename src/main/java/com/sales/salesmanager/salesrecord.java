package com.sales.salesmanager;
import jakarta.persistence.*;
@Entity
@Table(name="salesrecord")

public class salesrecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productname;
    private String month;
    private int quantity;
    private int price;
  private long totalamount;
  private long totalrevenue;
    public salesrecord(){};
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getProductname(){
        return productname;
    }
    public void setProductname(String productname){
        this.productname = productname;
    }
     public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
     public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
     public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public long getTotalamount(){
        return totalamount;
    }
    public void setTotalamount(long totalamount){
        this.totalamount = totalamount;
    }
    public long getTotalrevenue(){
        return totalrevenue;
    }
    public void setTotalrevenue(long totalrevenue){
        this.totalrevenue = totalrevenue;
    }
    
}
