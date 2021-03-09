package study.eatgo.enumer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
Converter을 String으로 해주면 String으로도 저장하고, 가져오는 것이 가능.
 */
@Converter
public class RegionConverter implements AttributeConverter<Region, Integer> {

    /*
    Region을 DB에 저장할 때.
     */
    @Override
    public Integer convertToDatabaseColumn(Region region) {
        return region.getCode();
    }

    /*
    Region을 Integer을 Region으로 변환하는 것.
     */
    @Override
    public Region convertToEntityAttribute(Integer code) {
        return Region.fromCode(code);
    }
}
