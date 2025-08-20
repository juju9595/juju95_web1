package 종합.평가3.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MoneyDto {
    private int custno;
    private String custname;
    private String grade;
    private int totalPrice;
}
