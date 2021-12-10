package cn.ubugs.job.domain.resp;

import lombok.Data;

import java.util.List;

@Data
public class PageListResp<T> {
    List<T> list;
    private int total;
}
