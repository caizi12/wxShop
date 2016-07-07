package ngves.asiainfo.core.csvc;

public class CsvcException extends Exception{
    /**
     * 
     */
    private static final long serialVersionUID = -8631449012570282071L;
    private String responseCode;
    private String responseDesc;

    public CsvcException(String responseCode, String responseDesc) {
        super(responseDesc);
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
}
