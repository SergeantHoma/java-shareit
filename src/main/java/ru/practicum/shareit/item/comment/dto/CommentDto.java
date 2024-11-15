package ru.practicum.shareit.item.comment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.shareit.item.model.Item;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class CommentDto {
    private Long id;
    private String text;
    private Item item;
    private String authorName;
    private LocalDateTime created = LocalDateTime.now();
}
