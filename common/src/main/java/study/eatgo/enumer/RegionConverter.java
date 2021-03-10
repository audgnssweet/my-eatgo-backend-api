package study.eatgo.enumer;

import org.springframework.core.convert.converter.Converter;

public class RegionConverter implements Converter<String, Region> {

    @Override
    public Region convert(String code) {
        return Region.fromCode(Integer.valueOf(code));
    }
}
