/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:51 PM
 * Filename : Foods
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.domain;


public class Food {
    private Integer id;
    private String name;
    private String description;
    private String price;
    private Integer restaurant;
    private String type;
    private byte[] imagefood;

    public Food() {
    }

    public Food(Integer id, String name, String description, String price, Integer restaurant, String type, byte[] imagefood) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.type = type;
        this.imagefood = imagefood;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImagefood() {
        return imagefood;
    }

    public void setImagefood(byte[] imagefood) {
        this.imagefood = imagefood;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", restaurant=" + restaurant +
                ", type='" + type + '\'' +
                ", imagefood=" + imagefood +
                '}';
    }
}
