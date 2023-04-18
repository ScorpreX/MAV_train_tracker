
package hu.myprojects.vf.mav;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Train implements Serializable
{

    @SerializedName("timetable")
    @Expose
    private List<Timetable> timetable;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("route")
    @Expose
    private String route;


    public Train() {
    }


    public Train(List<Timetable> timetable, String date, String route) {
        super();
        this.timetable = timetable;
        this.date = date;
        this.route = route;
    }

    public List<Timetable> getTimetable() {
        return timetable;
    }

    public String getDate() {
        return date;
    }

    public String getRoute() {
        return route;
    }


}
