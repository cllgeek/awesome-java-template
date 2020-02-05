package com.geekjc.redis.modules.common.validator;

import com.geekjc.redis.modules.common.exception.MyException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ll
 * @date 2020年02月05日 10:32 AM
 * 参数校验验证器
 */
public class TextFormatValidatorClass implements ConstraintValidator<TextFormat, Object> {

    private boolean notChinese;
    private String[] contains;
    private String[] notContains;
    private String startWith;
    private String endsWith;
    private String message;

    @Override
    public void initialize(TextFormat textFormat) {
        this.notChinese = textFormat.notChinese();
        this.contains = textFormat.contains();
        this.notContains = textFormat.notContains();
        this.startWith = textFormat.startWith();
        this.endsWith = textFormat.endsWith();
        this.message = textFormat.message();
    }

    @Override
    public boolean isValid(Object type, ConstraintValidatorContext context) {
        String target = (String) type;
        if (type instanceof String) {
            if (notChinese) {
                Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m = pattern.matcher(target);
                if (m.find()) {
                    throw new MyException(message);
                }
            }

            for (int j = 0; j < contains.length; j++) {
                if (!target.contains(contains[j])) {
                    throw new MyException(message);
                }
            }

            for (int j = 0; j < notContains.length; j++) {
                if (target.contains(notContains[j])) {
                    throw new MyException(message);
                }
            }

            if (!StringUtils.isEmpty(startWith)) {
                if (!target.startsWith(startWith)) {
                    throw new MyException(message);
                }
            }

            if (!StringUtils.isEmpty(target)) {
                if (!target.endsWith(endsWith)) {
                    throw new MyException(message);
                }
            }
        } else if (type instanceof Integer) {

        }
        return true;
    }

}
