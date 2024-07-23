package com.kitri.myspringboard.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private List<Comment> comments = new ArrayList<>();
}
