
package com.example.acronymapp.model.datasource.acronym;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lf implements Parcelable
{

    @SerializedName("lf")
    @Expose
    private String lf;
    @SerializedName("freq")
    @Expose
    private String freq;
    @SerializedName("since")
    @Expose
    private String since;
    @SerializedName("vars")
    @Expose
    private List<Var> vars = null;
    public final static Creator<Lf> CREATOR = new Creator<Lf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Lf createFromParcel(Parcel in) {
            return new Lf(in);
        }

        public Lf[] newArray(int size) {
            return (new Lf[size]);
        }

    }
    ;

    protected Lf(Parcel in) {
        this.lf = ((String) in.readValue((String.class.getClassLoader())));
        this.freq = ((String) in.readValue((String.class.getClassLoader())));
        this.since = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.vars, (com.example.acronymapp.model.datasource.acronym.Var.class.getClassLoader()));
    }

    public Lf() {
    }

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public List<Var> getVars() {
        return vars;
    }

    public void setVars(List<Var> vars) {
        this.vars = vars;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lf);
        dest.writeValue(freq);
        dest.writeValue(since);
        dest.writeList(vars);
    }

    public int describeContents() {
        return  0;
    }

}
