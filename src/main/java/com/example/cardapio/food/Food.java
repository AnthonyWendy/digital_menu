package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private float price;

    public Food(FoodRequestDto data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

}
