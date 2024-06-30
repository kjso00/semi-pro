package com.ohgiraffers.semipro;

import com.ohgiraffers.DTO.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SharePostController {

    @GetMapping("share-post")
    public String getPosts(Model model) {
        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOList.add(new PostDTO("부산", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAyMjdfMjE2%2FMDAxNzA5MDA4MjUxNTAx.nLVc9XLd57jsoLHvr5lxVS6auX5bGVfMQKcCU3qc-q0g.5alCX6gXaHhSiVsJvJ8eDR31Dxgnoq8FHkfX3CSHNN4g.JPEG%2F%25C6%25C4%25C0%25CC%25B8%25AE_26.jpg&type=ff332_332", "김 화연", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("부산", "https://search.pstatic.net/sunny/?src=http%3A%2F%2Ffile3.instiz.net%2Fdata%2Ffile3%2F2018%2F09%2F20%2F1%2F2%2F7%2F127ea8c59a5b332ceafcccdfcf7415b6.jpg&type=a340", "홍 서우", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("서울", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAyMjlfMTAg%2FMDAxNzA5MTM2MTg4MjQw.SBtA5l_R42W5T1djRSpvP_9JoYj-1XwJnXttLKFtbgkg.SrvdH3hAKAt4Z2HiBelfpHb56onHhLEwYan8XVbrEQ0g.JPEG%2FOIG2.jpg&type=a340", "목 진희", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("서울", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMDJfMTQx%2FMDAxNjk4ODk4MzA5Nzk2.jt9NtraCCMy8TJYms5mnnbHkzfiZOt2qLQR4izb_30wg.PtFBvdPzbbxw6PR5rtALLcjAx3aulgA3vAEiaYGOsFIg.JPEG.gnfnffkffk%2FPokemonAG039%25A3%25DF%25A3%25AD%25A3%25DF%253F%2595%254C%253F%253F%253F%25A3%25DF%253F%253F%253F%253F%253F%25A3%25DF%253F%253F%253F%253F%253F%253F.avi%25A3%25DF000501866.jpg&type=sc960_832", "김 효연", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("제주", "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fi.pinimg.com%2Foriginals%2Fa0%2F11%2F88%2Fa01188c17c5c11b1e7e5208df5f79819.png&type=sc960_832", "신 주연", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("제주", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAxMTRfMTMx%2FMDAxNjczNjcyOTM4NjMx.2YgQWgIvQ_xBydJtNPeSzdNALzY0rI4uLdGrWiEoWtIg.NdQ56H5KHvlgh1WghyPU2zOpQglbvnMCLgcZUlJ-F5Eg.PNG.jaeoh413%2Fimage.png&type=sc960_832", "김 재석", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("인천", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20140206_176%2Fkiron24_1391650024714PYiir_PNG%2F%25B0%25ED%25B6%25F3%25C6%25C4%25B4%25F6-01.png&type=a340", "김 준성", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));
        postDTOList.add(new PostDTO("인천", "https://photo.coolenjoy.co.kr/data/editor/2208/thumb-f83b1f4f93227114b021b4fe1cef9aa10636e128.jpg", "한 소희", "두 번째 게시물의 세 줄 미리보기입니다. 여기에는 더 많은 내용이 있을 수 있습니다."));

        model.addAttribute("posts", postDTOList);
        return "share-post";
    }
}