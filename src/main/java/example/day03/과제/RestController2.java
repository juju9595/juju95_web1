package example.day03.과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RestController2 {

    @PostMapping("/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("RestController2.board1");
        System.out.println("boardDto =" + boardDto);
        return true;
    }
    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto());
        System.out.println("RestController2.boardDtos");
        return list;

    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        System.out.println("RestController2.board3");
        System.out.println("bno = " + bno);
        BoardDto boardDto = new BoardDto();
        return boardDto;
    }

    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("RestController2.board4");
        System.out.println("bno = " + bno);
        return true;
    }

    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        System.out.println("RestController2.board5");
        System.out.println("boardDto = " + boardDto);
        return true;
    }

}
