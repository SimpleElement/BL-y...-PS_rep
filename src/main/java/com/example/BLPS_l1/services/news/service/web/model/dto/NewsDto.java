package com.example.BLPS_l1.services.news.service.web.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class NewsDto {

    @NotNull(message = "Необходимо указать id новости, которое не может быть пустым")
    @Min(value = 0, message = "id должен быть больше 0")
    @Max(value = 2147483647, message = "id должен быть меньше 2147483647")
    private BigInteger id;

    private String author;

    private String topic;

    private String description;

    private Date data;

    private List<LikeDto> likes;

    private List<CommentDto> comments;
}
