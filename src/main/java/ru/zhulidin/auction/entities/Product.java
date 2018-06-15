package ru.zhulidin.auction.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Не может быть пустым")
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Не может быть пустым")
    private Integer price;

    @Column(name = "redemptionPrice", nullable = false)
    @NotNull(message = "Не может быть пустым")
    private Integer redemptionPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_created")
    @Temporal(TIMESTAMP)
    private Date dateCreated;

    @Column(name = "description", nullable = false, length = 8096)
    @Length(max=8096, message = ">8000")
    private String description;

    @OneToOne
    private User owner;

    @OneToOne
    private User boyer;

    @Column(name = "available")
    private boolean available;

    public Product() {
    }

    public Product(String name, Integer price, String description, Integer redemptionPrice) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.redemptionPrice =redemptionPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getBoyer() {
        return boyer;
    }

    public void setBoyer(User boyer) {
        this.boyer = boyer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getRedemptionPrice() {
        return redemptionPrice;
    }

    public void setRedemptionPrice(Integer redemptionPrice) {
        this.redemptionPrice = redemptionPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
