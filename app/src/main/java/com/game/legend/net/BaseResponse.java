package com.game.legend.net;

import java.io.Serializable;

/**
 * Created by LiuCongshan on 2016/6/21.
 * BaseResponse
 */
public class BaseResponse implements Serializable {
    public String ret_code;
    public String ret_msg;

    public boolean isSuccess() {
        return "000000".equals(ret_code);
    }
}
