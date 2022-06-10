package aptech.demopractical.entity;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private BigDecimal price;

}
