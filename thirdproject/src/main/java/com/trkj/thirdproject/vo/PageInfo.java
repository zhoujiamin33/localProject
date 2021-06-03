package com.trkj.thirdproject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
    private Integer currentPage;
    private Integer pagesize;
    private Integer total;
}
