package hu.myprojects.vf.mav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Timetable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("starttime")
    @Expose
    private String starttime;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("destinationtime")
    @Expose
    private String destinationtime;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("totaltime")
    @Expose
    private String totaltime;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("cost1st")
    @Expose
    private String cost1st;
    @SerializedName("cost2nd")
    @Expose
    private String cost2nd;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("class_name")
    @Expose
    private String className;
    @SerializedName("details")
    @Expose
    private List<Detail> details = null;

    public Timetable() {
    }

    public Timetable(String type, String starttime, String start, String destinationtime, String destination, String change, String totaltime, String distance, String cost1st, String cost2nd, String _class, String className, List<Detail> details) {
        super();
        this.type = type;
        this.starttime = starttime;
        this.start = start;
        this.destinationtime = destinationtime;
        this.destination = destination;
        this.change = change;
        this.totaltime = totaltime;
        this.distance = distance;
        this.cost1st = cost1st;
        this.cost2nd = cost2nd;
        this._class = _class;
        this.className = className;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getStart() {
        return start;
    }

    public String getDestinationtime() {
        return destinationtime;
    }

    public String getDestination() {
        return destination;
    }

    public String getChange() {
        return change;
    }

    public String getTotaltime() {
        return totaltime;
    }

    public String getDistance() {
        return distance;
    }

    public String getCost1st() {
        return cost1st;
    }

    public String getCost2nd() {
        return cost2nd;
    }

    public String getKlass_() {
        return _class;
    }

    public String getClassName() {
        return className;
    }

    public List<Detail> getDetails() {
        return details;
    }
}
