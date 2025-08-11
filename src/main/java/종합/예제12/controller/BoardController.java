package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board") // +공통 URL
public class BoardController {
    @Autowired private BoardService boardService;

    //(1) 등록 기능 구현
    @PostMapping("")//localhost:8080/board
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardWrite(boardDto);// 서비스 호출 하고 응답을 반환
        return result;
    }

    //(2) 전제조회 기능 구현
    @GetMapping("")
    public List<BoardDto> boardPrint(){
        List<BoardDto> result = boardService.boardPrint();
        return result;
    }

    //(3) 개별조회 기능 구현
    @GetMapping("/find") //localhost:8080/board/find?bno=1
    public BoardDto boardFind(@RequestParam int bno){
        System.out.println("BoardController.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.boardFind(bno);
        return result;
    }

    //(4) 삭제 기능 구현
    @DeleteMapping("") //localhost:8080/board?bno=1
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardService.boardDelete(bno);
        return result;
    }

    // (5) 수정 기능 구현
    @PutMapping("")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardUpdate(boardDto);
        return result;
    }
}//class e
