package org.demo_thymeleaf.util;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@UtilityClass
public final class CommonFunc {

    public LocalDate convertTimeStampToLocalDate(Timestamp src) {
        if (Objects.isNull(src)) {
            return null;
        }
        return src.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
