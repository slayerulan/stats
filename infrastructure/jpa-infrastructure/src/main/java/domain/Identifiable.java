package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Identifiable - Суперкласс для всех сущностей справочников
 *
 * @author Калистратов Сергей Юрьевич (skalistratov)
 * @since 03.04.2017
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class Identifiable {

    @Id
    @GenericGenerator(name = "sequence", strategy = "sequence")
    @GeneratedValue(generator = "sequence")
    private Long id;
}
