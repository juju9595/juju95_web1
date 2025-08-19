package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController // 스프링 컨테이너의 빈 등록
@RequestMapping("/file")
public class FileController {

    @Autowired// 스프링 컨테이너 에서 빈 꺼내오기
    private FileService fileService;
    //[1] 업로드
    //
    //POST,
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("multipartFile = " + multipartFile);
        System.out.println("FileController.fileUpload");
        String result = fileService.fileUpload(multipartFile);
        return result;
    }//func e

    //[2] 다운로드
    @GetMapping("/download")
    //GET, http://localhost:8080/file/download?fileName=4771d83d-b207-4da8-839a-51d79fe51c61_202212008462-500.jpg
    public void fileDownload(@RequestParam String fileName , HttpServletResponse response){
        fileService.fileDownload(fileName, response);
    }

    //[3] 파일 삭제
    @GetMapping("/delete")
    public boolean fileDelete(@RequestParam String fileName){
        boolean result = fileService.fileDelete(fileName);
        return result;
    }
}//class e
