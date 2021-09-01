package org.csystem.springboot.app;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
@Accessors(prefix = "m_")
@NoArgsConstructor
@RequiredArgsConstructor
public class DeviceInfo {
    private int m_id;
    private @NonNull String m_name;
    private @NonNull LocalDate m_productDate;

    public String toString()
    {
        return String.format("%s:%s", m_name, m_productDate);
    }

}
