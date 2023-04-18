package hu.myprojects.vf.mav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Detail implements Serializable {

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("dep")
    @Expose
    private String dep;

    @SerializedName("dep_real")
    @Expose
    private String depReal;

    @SerializedName("platform")
    @Expose
    private String platform;

    @SerializedName("train_info")
    @Expose
    private TrainInfo trainInfo;

    @SerializedName("services")
    @Expose
    private List<Service> services = null;

    @SerializedName("original_way")
    @Expose
    private List<String> originalWay = null;

    public Detail() {
    }


    public Detail(String from, String dep, String depReal, String platform, TrainInfo trainInfo, List<Service> services, List<String> originalWay) {
        super();
        this.from = from;
        this.dep = dep;
        this.depReal = depReal;
        this.platform = platform;
        this.trainInfo = trainInfo;
        this.services = services;
        this.originalWay = originalWay;
    }

    public String getFrom() {
        return from;
    }

    public String getDep() {
        return dep;
    }

    public String getDepReal() {
        return depReal;
    }

    public String getPlatform() {
        return platform;
    }

    public TrainInfo getTrainInfo() {
        return trainInfo;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<String> getOriginalWay() {
        return originalWay;
    }


}
