package top.young.analysis.entity;

/**
 * @Method: top.young.analysis.entity
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/1/31 15:41
 */
public class WSServerMsg {
    private String response;

    public WSServerMsg(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
