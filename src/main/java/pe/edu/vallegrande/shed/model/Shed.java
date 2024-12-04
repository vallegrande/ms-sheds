package pe.edu.vallegrande.shed.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("shed")
public class Shed {

    @Id
    private Long id;

    private String name;

    private String location;

    private Integer capacity;

    private String chickenType;

    private java.time.LocalDate inspectionDate;

    private String note;

    private Character status = 'A';
}
