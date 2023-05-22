package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.koreait.commons.constants.Role;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseMemberEntity{
    @Id
    @Column(length = 30)
    private String bId; // 게시판아이디

    @Column(length = 60, nullable = false)
    private String bName; // 게시판명

    @Column(name="isUse") // mysql 에서 use 는 예약어이기 떄문에 컬럼값을 다르게 사용한다
    private boolean use; // 게시판 사용여부

    private int rowsOfPage = 20; //1페이지당 게시글

    private boolean showViewList; // 게시글 하단 목록 노출

    @Lob
    private String category; // 게시판 분류


    // 목록 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role listAccessRole = Role.ALL;
    // 글보기 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role viewAccessRole = Role.ALL;
    // 글쓰기 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role writeAccessRole = Role.ALL;
    // 답글 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role replyAccessRole = Role.ALL;
    // 댓글 접근 권한
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role commentAccessRole = Role.ALL;


    // 에디터 사용 여부
    private boolean useEditor;

    // 파일 첨부 사용여부
    private boolean useAttachFile;

    // 이미지 첨부 사용 여부
    private boolean useAttachImage;



    // 글작성 후 이동
    @Column(length = 10, nullable = false)
    private String locationAfterWriting = "view";

    // 답글 사용 여부
    private boolean useReply;
    // 댓글 사용 여부
    private boolean useComment;


    // 게시판 스킨
    @Column(length = 20,nullable = false)
    private String skin = "default";



}