package 종합.평가3.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MoneyDto {
    private int custno;
    private int salenol;
    private int pcost;
    private int amount;
    private int price;
    private String pcode;
    private String sdate;
}
