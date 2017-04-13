package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
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
    @Property(optionality = Optionality.OPTIONAL)
    private Long id;
}
