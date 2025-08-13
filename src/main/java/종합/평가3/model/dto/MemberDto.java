package 종합.평가3.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MemberDto {
    private int custno;
    private String custname;
    private String phone;
    private String address;
    private Date joindate;
    private String grade;
    private String city;
}
