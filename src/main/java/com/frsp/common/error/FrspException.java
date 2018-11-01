package com.frsp.common.error;

import com.frsp.common.enums.ErrcodeEnum;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Data
public class FrspException extends RuntimeException {
    private static final Log log= LogFactory.getLog(FrspException.class);

    private Integer errcode;

    public FrspException() {
        super(ErrcodeEnum.SYS_ERR.getMessage());
        this.errcode = ErrcodeEnum.SYS_ERR.getCode();
    }

    public FrspException(ErrcodeEnum errcodeEnum) {
        super(errcodeEnum.getMessage());
        this.errcode = errcodeEnum.getCode();
    }

    public FrspException(ErrcodeEnum errcodeEnum, Exception e) {
        super(errcodeEnum.getMessage());
        this.errcode = errcodeEnum.getCode();
        log.error(errcodeEnum,e);
    }

}
