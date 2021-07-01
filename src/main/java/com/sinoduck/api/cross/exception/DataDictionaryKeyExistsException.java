package com.sinoduck.api.cross.exception;

import com.sinoduck.api.db.entity.DataDictionary;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author where.liu
 */
public class DataDictionaryKeyExistsException extends Exception {
    @Getter
    private final DataDictionary dataDictionary;

    public DataDictionaryKeyExistsException(DataDictionary dataDictionary) {
        super(StringUtils.join("key: ", dataDictionary.getKey(), " 已存在"));
        this.dataDictionary = dataDictionary;
    }
}
