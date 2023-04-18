
package hu.myprojects.vf.mav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Service implements Serializable {

    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("text")
    @Expose
    private String text;


    public Service() {
    }

    public Service(String icon, int code, String key) {
        super();
        this.icon = icon;
        this.code = code;
        this.key = key;
    }

    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
}
