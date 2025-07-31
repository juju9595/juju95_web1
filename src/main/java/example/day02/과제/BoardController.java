package example.day02.과제;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    //1
    @PostMapping("/day02/board")
    @ResponseBody
    public boolean board1(){
        System.out.println("BoardController.board1");
        return false;
    }
    //2
    @GetMapping("/day02/board")
    @ResponseBody
    public List<BoardDto>board2(){
        System.out.println("BoardController.board2");
        ArrayList<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto());
        list.add(new BoardDto());
        return list;
    }

    //3
    @GetMapping("/day02/board/view")
    @ResponseBody
    public Map<Integer, String>board3(){
        System.out.println("BoardController.board3");
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"null");
        return map;
    }

    //4
    @PutMapping("/day02/board")
    @ResponseBody
    public boolean board4(){
        System.out.println("BoardController.board4");
        return true;
    }

    //5
    @DeleteMapping("/day02/board")
    @ResponseBody
    public int board5() {
        System.out.println("BoardController.board5");
        return 3;
    }
}
