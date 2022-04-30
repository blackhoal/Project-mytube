package com.jason.myonlytube.dto;

import com.jason.myonlytube.model.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
    private String id;
    private String title;
    private boolean done;
//    private Integer boardNo;
//    private String type;
//    private String title;
//    private String contents;
//    private String userId;
//    private Date createdTime;
//    private Date updatedTime;
//    private Integer likes;
//    private Integer counts;

    public BoardDTO(final BoardEntity entity) {
//        this.boardNo = entity.getBoardNo();
//        this.type = entity.getType();
//        this.title = entity.getTitle();
//        this.contents = entity.getContents();
//        this.userId = entity.getUserId();
//        this.createdTime = entity.getCreatedTime();
//        this.updatedTime = entity.getUpdatedTime();
//        this.likes = entity.getLikes();
//        this.counts = entity.getCounts();
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static BoardEntity toEntity(final BoardDTO dto) {
        return BoardEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
