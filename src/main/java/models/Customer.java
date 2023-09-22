package models;

import jakarta.persistence.*;







@Entity

@Table(name ="customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long cust_id; // Mã khách hàng, sẽ tự động tạo dựa vào cơ sở dữ liệu

    @Column(name = "cust_name")
    private String cust_name; // Tên khách hàng

    @Column(name = "email")
    private String email; // Địa chỉ email

    @Column(name = "phone")
    private String phone; // Số điện thoại

    @Column(name = "address")
    private String address; // Địa chỉ

    // Constructors

    public Customer() {
    }

    public Customer(Long cust_id, String cust_name, String email, String phone, String address) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


    public Customer( String cust_name, String email, String phone, String address) {

        this.cust_name = cust_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }


// Getters and setters

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", email=" + email + ", phone=" + phone
                + ", address=" + address + "]";
    }
}
