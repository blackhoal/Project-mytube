package com.jason.myonlytube.controller;

import com.jason.myonlytube.dto.BoardDTO;
import com.jason.myonlytube.dto.ResponseDTO;
import com.jason.myonlytube.model.BoardEntity;
import com.jason.myonlytube.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/test")
    public ResponseEntity<?> testBoard() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardDTO dto) {
        try {
            String temporaryUserId = "temporary-user";

            BoardEntity entity = BoardDTO.toEntity(dto);

            entity.setId(null);

            entity.setUserId(temporaryUserId);

            List<BoardEntity> entities = service.create(entity);

            List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());

            ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
