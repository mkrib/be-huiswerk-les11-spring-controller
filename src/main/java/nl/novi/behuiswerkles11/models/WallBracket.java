package nl.novi.behuiswerkles11.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wallBracket")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
    @ManyToMany
    @JoinTable(
            name = "wallBrackets_televisions",
            joinColumns = @JoinColumn(name = "televisionId"),
            inverseJoinColumns = @JoinColumn(name = "wallbracketId")
    )
    private List<Television> televisions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
