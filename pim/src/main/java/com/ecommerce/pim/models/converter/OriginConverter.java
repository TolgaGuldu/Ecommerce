package com.ecommerce.pim.models.converter;

import com.ecommerce.pim.models.Origin;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Created on October 2022
 *
 * @author tolga
 */

@Converter(autoApply = true)
public class OriginConverter implements AttributeConverter<Origin, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Origin origin) {
        if (origin == null) {
            return null;
        }
        return origin.getSort();
    }

    @Override
    public Origin convertToEntityAttribute(Integer origin) {
        if (origin == null) {
            return null;
        }

        return Stream.of(Origin.values())
                .filter(c -> c.getSort().equals(origin))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
