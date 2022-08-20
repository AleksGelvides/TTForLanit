package com.gelvides.ttforlanit.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Statistic {
    private Long personcount;
    private Long carcount;
    private Long unicvendorcount;
}
