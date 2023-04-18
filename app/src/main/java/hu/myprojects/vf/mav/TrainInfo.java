
package hu.myprojects.vf.mav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TrainInfo implements Serializable
{

    @SerializedName("services")
    @Expose
    private List<Service> services = null;

    @SerializedName("href")
    @Expose
    private String href;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("get_url")
    @Expose
    private String get_url;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("info")
    @Expose
    private String info;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("is_local_transport")
    @Expose
    private boolean is_local_transport;


    public TrainInfo() {
    }

    public TrainInfo(List<Service> services, String href, String url, String get_url, String code, String text, String info, String type, boolean is_local_transport) {
        this.services = services;
        this.href = href;
        this.url = url;
        this.get_url = get_url;
        this.code = code;
        this.text = text;
        this.info = info;
        this.type = type;
        this.is_local_transport = is_local_transport;
    }


    public List<Service> getServices() {
        return services;
    }

    public String getHref() {
        return href;
    }

    public String getUrl() {
        return url;
    }

    public String getGet_url() {
        return get_url;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public String getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }

    public boolean isIs_local_transport() {
        return is_local_transport;
    }
}
