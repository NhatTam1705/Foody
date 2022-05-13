/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Wed, 5/11/2022
 * Time     : 2:19 PM
 * Filename : Restaurant
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.domain;

import java.util.List;

public class Restaurant {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private byte[] imagerestaurant;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, String phone, String address, byte[] imagerestaurant) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.imagerestaurant = imagerestaurant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public byte[] getImagerestaurant() {
        return imagerestaurant;
    }

    public void setImagerestaurant(byte[] imagerestaurant) {
        this.imagerestaurant = imagerestaurant;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", imagerestaurant='" + imagerestaurant + '\'' +
                '}';
    }
}
